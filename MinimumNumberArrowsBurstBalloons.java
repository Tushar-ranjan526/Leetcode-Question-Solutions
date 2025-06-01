import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsBurstBalloons {
    public static void main(String[] args) {
        MinimumNumberArrowsBurstBalloons ma=new MinimumNumberArrowsBurstBalloons();
        int[][] points={{10,16},{2,8},{1,6},{7,12}};
        System.out.println(ma.findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int ans=0;
        long maxi=Long.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            long ub=points[i][1];
            long lb=points[i][0];
            if(maxi<lb) {
                ans++;
                maxi = ub;
            }
        }
        return ans;
    }
    public void printArray(int[][] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
