package Leetcode;

import java.util.Arrays;

public class Jumpstairs {
    public static void main(String[] args) {
        int[] cost={10,15,20};
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        System.out.println(Math.min(climb(cost.length-1,cost,dp),climb(cost.length-2,cost,dp)));
    }
    public static int climb(int n,int[] cost,int[] dp){
        if(n<0)
                return 0;
        if(n==0 || n==1)
            return cost[n];
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=cost[n]+Math.min(climb(n-1,cost,dp),climb(n-2,cost,dp));
    }
}
