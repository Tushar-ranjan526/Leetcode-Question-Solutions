package Leetcode;

import java.util.Arrays;

public class MaximumRewardUsingOperation {
    public static void main(String[] args) {
        int[] nums={1,6,4,3,2};
        System.out.println(maxTotalReward(nums));
    }
    public static int maxTotalReward(int[] rewardValues) {
        int[][] dp=new int[2001][4000];
        Arrays.sort(rewardValues);
        return calcMaxReward(0,0,rewardValues,dp);
    }
    public static int calcMaxReward(int i,int profit,int[] nums,int[][] dp){
        if(i==nums.length-1) {
         if(profit<nums[i])return profit+nums[i];
         return 0;
        }
        if(dp[i][profit]!=0)return dp[i][profit];
        int take=-1;
        if(profit<nums[i]){
            take=calcMaxReward(i+1,profit+nums[i],nums,dp);
        }
        int nottake=calcMaxReward(i+1,profit,nums,dp);


        return dp[i][profit]=Math.max(take,nottake);
    }
}
