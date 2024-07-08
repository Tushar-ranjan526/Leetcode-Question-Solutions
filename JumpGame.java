package Leetcode;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums={2,5,0,0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        Boolean[] dp=new Boolean[nums.length];
        return jump(0,nums,dp);
    }
    public static boolean jump(int n,int[] nums,Boolean[] dp){
        if(n==nums.length-1 || n>nums.length-1)return true;
        if(dp[n]!=null)return dp[n];
        boolean prev=false;
        for(int i=1;i<=nums[n];i++){
            prev =jump(n+i,nums,dp);
        }
        return dp[n]=prev;
    }
}
