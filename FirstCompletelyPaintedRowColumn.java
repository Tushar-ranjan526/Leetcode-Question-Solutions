import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowColumn {
    public static void main(String[] args) {
        int[] arr={1,4,5,2,6,3};
        int[][] matrix={{4,3,5},{1,2,6}};
        FirstCompletelyPaintedRowColumn fs=new FirstCompletelyPaintedRowColumn();
        System.out.println(fs.firstCompleteIndex(arr,matrix));
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Map<Integer,int[]> mpp=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mpp.put(mat[i][j],new int[]{i,j});
            }
        }
        int[][] fill=new int[m+n][2];
        for(int i=0;i<fill.length/m;i++){
            fill[i][0]=0;
            fill[i][1]=n;
        }
        for(int i=n-1;i<fill.length;i++) {
            fill[i][0] = 0;
            fill[i][1] = m;
        }
        for(int i=0;i<arr.length;i++){
            int[] pos=mpp.get(arr[i]);
            int row=pos[0];
            int col=pos[1];
            fill[row][0]+=1;
            if(fill[row][0]==fill[row][1])return i;
            fill[fill.length/2+col][0]+=1;
            if(fill[fill.length/2+col][0]==fill[fill.length/2+col][1])return i;
        }
        return -1;
    }

}
