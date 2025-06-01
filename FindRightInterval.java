import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public static void main(String[] args) {
        FindRightInterval fi=new FindRightInterval();
        int[][] intervals={{3,4},{2,3},{1,2}};
        int[] ans=fi.findRightInterval(intervals);
        System.out.println(Arrays.toString(ans));
    }
    public int[] findRightInterval(int[][] intervals){
        int n=intervals.length;
        int[][] modified=new int[intervals.length][3];
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
                int start=intervals[i][0];
                int end=intervals[i][1];
                modified[i][0]=start;
                modified[i][1]=end;
                modified[i][2]=i;
        }
        Arrays.sort(modified, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<n;i++){
           int end=modified[i][1];
           ans[modified[i][2]]=searchInArray(end,modified);
        }
        return ans;
    }
    public int searchInArray(int tar,int [][] arr){
        int s=0,e=arr.length-1,ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid][0]>tar){
                ans=arr[mid][2];
                e=mid-1;
            }
            else if(arr[mid][0]<tar){
                s=mid+1;
            }else{
                ans=arr[mid][2];
                return ans;
            }
        }
        return ans;
    }
}
