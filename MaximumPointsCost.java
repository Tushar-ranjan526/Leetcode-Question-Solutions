package Leetcode;

import java.util.Arrays;

public class MaximumPointsCost {
    public static void main(String[] args) {
        int[][] points={
                {1, 5},
                {2, 3},
                {4, 2}
        };
        MaximumPointsCost mx=new MaximumPointsCost();
        System.out.println(mx.maxPoints(points));
    }
    public long maxPoints(int[][] points) {
        long[][] dp=new long[points.length+1][points[0].length+1];
        long ans=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
            for (int i= 0;i<points[0].length;i++){
                ans=Math.max(ans,retPoints(0,0+i,points,dp));
            }
            return ans;
    }

    public long retPoints(int r, int c, int[][] points,long[][] dp) {
        if(r>=points.length || c>=points[0].length){
            return 0;
        }
        if(r==points.length-1 ){
            return points[r][c];
        }
        if(dp[r][c]!=-1)return dp[r][c];
        long ans=Integer.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            long val=retPoints(r+1,0+i,points,dp);
            ans=Math.max(ans,val-Math.abs(c-(i)));
        }
        return dp[r][c]=ans+points[r][c];
    }
}
