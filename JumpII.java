package Leetcode;

import java.util.Arrays;

public class JumpII {
    public static void main(String[] args) {
            int[] nums={2,3,0,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
            int[] dp=new int[nums.length];
            Arrays.fill(dp,-1);
            return jumpGame(0,nums,dp);
    }
    public static int jumpGame(int i,int[] nums,int[] dp){
        if(i==nums.length-1)return 0;
        if(i>=nums.length) return Integer.MAX_VALUE/100;
        if(dp[i]!=-1)return dp[i];
        int minJump=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            minJump=Math.min(minJump,1+jumpGame(i+j,nums,dp));
        }
        if(minJump==Integer.MAX_VALUE){
            return dp[i]=Integer.MAX_VALUE/10;
        }
        return dp[i]=minJump;
    }
}
