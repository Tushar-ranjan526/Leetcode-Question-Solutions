package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] matrix={
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        List<Integer> ans=luckyNumbers(matrix);
        System.out.println(ans);
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int[] miniRow=checkMini(matrix[i]);
            boolean checkmax=retMax(miniRow[1],miniRow[0],matrix);
            if(checkmax)ans.add(miniRow[0]);
        }
        return ans;
    }

    private static boolean retMax(int i,int mini,int[][] matrix) {
        for (int j = 0; j <matrix.length ; j++) {
            if(matrix[j][i]>mini)return false;
        }
        return true;
    }

    private static int[] checkMini(int[] matrix) {
        int[] mini=new int[2];
        mini[0]=Integer.MAX_VALUE;
        for (int i=0;i<matrix.length;i++){
            if(mini[0]>matrix[i]){
                mini[0]=matrix[i];
                mini[1]=i;
            }
        }
        return mini;
    }
}
