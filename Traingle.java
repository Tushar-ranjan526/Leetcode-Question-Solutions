package Leetcode;

public class Traingle {
    public static void main(String[] args) {
        int[][]  traingle={
                {1},{2,3},{3,6,7},{8,9,6,10}
        };
        int m=traingle.length;
        int[][] dp=new int[m][traingle[m-1].length];
        System.out.println(caclMin(0,0,traingle,dp));
    }
    public static int caclMin(int i,int j,int[][] traingle,int[][] dp){


        int m=traingle.length,n= traingle[m-1].length;
        if(i==m-1 || j== n-1)
            return traingle[i][j];
        if(i>=m || j>=n)return Integer.MAX_VALUE/100;
        if(dp[i][j]!=0) return dp[i][j];
        return dp[i][j]=traingle[i][j]+Math.min(caclMin(i+1,j,traingle,dp),caclMin(i+1,j+1,traingle,dp));
    }
}
