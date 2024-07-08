package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals={
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] ans = merge(intervals);
        printArray(ans);
    }
    public static void printArray(int[][] ans){
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j <ans[i].length ; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
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
