package Leetcode;

public class EqualPartition {
    public static void main(String[] args) {
        int[] nums={3,3,3,4,5};
        int k=0;
        for(int i=0;i<nums.length;i++){
            k+=nums[i];
        }
        if(k%2==0)k/=2;

        else
            System.out.println(false);
        boolean[][] dp=new boolean[nums.length][k+1];
        for(int j=0;j<nums.length;j++){
            dp[j][0]=true;
        }
        for(int m=1;m<nums.length;m++){
            for(int n=1;n<=k;n++){
                boolean notTake=dp[m-1][n];
                boolean take=false;
                if(k>=nums[m]){
                    take=dp[m-1][n-nums[m]];
                }
                dp[m][n]=take || notTake;
            }
        }
        System.out.println(dp[nums.length-1][k]);
    }

}
