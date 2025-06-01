import java.util.Arrays;

public class MaximumAmountOfMoneyRobotCanEarn {
    public static void main(String[] args) {
        int[][] coins={{-16,8,-7,-19},{6,3,-10,13},{13,15,4,-3},{-16,4,19,-12}};
        MaximumAmountOfMoneyRobotCanEarn mr=new MaximumAmountOfMoneyRobotCanEarn();
        System.out.println(mr.maximumAmount(coins));
    }
    public int maximumAmount(int[][] coins) {
        int n=coins.length;
        int m=coins[0].length;
        Integer[][][] dp=new Integer[n+1][m+1][3];

        return maxAmount(n-1,m-1,0,2,coins,dp);
    }
    public int maxAmount(int i,int j,int total,int neutral,int[][] coins,Integer[][][] dp){
        if(i==0 && j==0){
            int cost=0;
            if(coins[i][j]>=0){
                cost=total+coins[i][j];
            }else{
                if(neutral>0){
                    neutral--;
                    cost=total;
                }else{
                    cost=total+coins[i][j];
                }
            }
            return dp[i][j][neutral]=cost;
        }
        if(i<0 || j<0 || i>coins.length-1 || j>coins[0].length-1){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][neutral]!=null)return dp[i][j][neutral];
        int up=Integer.MIN_VALUE,left=Integer.MIN_VALUE;
        if(coins[i][j]<0){
            if(neutral>0){
                up=Math.max(up,maxAmount(i-1,j,total,--neutral,coins,dp));
                neutral++;
                left=Math.max(left,maxAmount(i,j-1,total,--neutral,coins,dp));
            }else{
                up=Math.max(up,maxAmount(i-1,j,total+coins[i][j],neutral,coins,dp));
                left=Math.max(left,maxAmount(i,j-1,total+coins[i][j],neutral,coins,dp));
            }
        }else{
            up=Math.max(up,maxAmount(i-1,j,total+coins[i][j],neutral,coins,dp));
            left=Math.max(left,maxAmount(i,j-1,total+coins[i][j],neutral,coins,dp));
        }

        return dp[i][j][neutral]=Math.max(up,left);
    }
}
