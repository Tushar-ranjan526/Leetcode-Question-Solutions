package Leetcode;
import java.util.*;
public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals={
                {1,3},
                {6,9}
        };
        int[] newInterval={2,5};
        int[][] ans=insert(intervals,newInterval);
        printArray(ans);
    }
    public static void printArray(int[][] ans){
        for (int i = 0; i <ans.length ; i++) {
            System.out.print("[");
            for (int j = 0; j <ans[0].length ; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] ans={newInterval};
            return ans;
        }
        int s=0,e=intervals.length-1,ind=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(intervals[mid][0]>newInterval[0])e=mid-1;
            else s=mid+1;
        }
        ind=e;
        intervals[ind][1]=Math.max(intervals[ind][1],newInterval[1]);
        List<int[]> list=new ArrayList<>();
        int[] interval=intervals[0];
        list.add(interval);
        for (int[] num:intervals){
            if(interval[1]>=num[0]){
                interval[1]=Math.max(interval[1],num[1]);
            }else{
                interval=num;
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
