package Leetcode;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins={2};
        int amount =1;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        changeArr(dp);
        if(minCoin(n-1,amount,coins,dp)==Integer.MAX_VALUE/10)return -1;
        return minCoin(n-1,amount,coins,dp);
    }
    public static void changeArr(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-10;
            }
        }
    }
    public static int minCoin(int n,int tar,int[] coins,int[][] dp){
        if(n==0){
            if(tar%coins[n]==0) return tar/coins[n];
            return Integer.MAX_VALUE/10;
        }
        if(dp[n][tar]!=-10) return dp[n][tar];
        int nottake=minCoin(n-1,tar,coins,dp);
        int take=Integer.MAX_VALUE;
        if(coins[n]<=tar)
            take=1+minCoin(n,tar-coins[n],coins,dp);

        return dp[n][tar]=Math.min(take,nottake);
    }
}
