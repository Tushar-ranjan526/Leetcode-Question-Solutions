package Leetcode;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums={1,2,1};
        int target=0;
        int n=nums.length,totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        if(totalSum-target<0 || (totalSum-target)%2!=0){ System.out.println(0);return;}
        int[][] dp=new int[n][target+1];
        int newtar=(totalSum-target)/2;
        System.out.println(countSum(n-1,newtar,nums,dp));
    }

    public static int countSum(int n,int tar,int[] nums,int[][] dp){
        if(n==0){
            if(tar==0 && nums[0]==0)return 2;
            if(tar==0 || nums[0]==tar) return 1;
        }
        if(dp[n][tar]!=0) return dp[n][tar];
        int nottake=countSum(n-1,tar,nums,dp);
        int take=0;
        if(nums[n]<=tar)
            take=countSum(n-1,tar-nums[n],nums,dp);

        return dp[n][tar]=take+nottake;
    }
}
