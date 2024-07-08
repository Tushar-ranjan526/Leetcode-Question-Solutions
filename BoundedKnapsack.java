package Leetcode;

import java.util.ArrayList;

public class BoundedKnapsack {
    public static void main(String[] args) {
        ArrayList<Integer> weights=new ArrayList<>();
        weights.add(6);
        weights.add(1);
        weights.add(5);
        weights.add(3);
        ArrayList<Integer> values=new ArrayList<>();
        values.add(3);
        values.add(6);
        values.add(1);
        values.add(4);
        int w= 10;
        System.out.println(weights);
        System.out.println(values);
        System.out.println(maxProfit(values,weights,values.size(),w));

    }

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
       int[][] dp=new int[n][w+1];
       initializeDp(dp);
        return maxCalc(n-1,w,values,weights,dp);
    }
    public static void initializeDp(int[][] dp){
        for ( int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    public static int maxCalc(int n,int maxw,ArrayList<Integer> values,ArrayList<Integer> weights,int[][]dp) {
        if (n == 0) {
            if (maxw >= weights.get(n)) return values.get(n);
            else return 0;
        }
        if (dp[n][maxw] != -1) return dp[n][maxw];
        int nottake = 0 + maxCalc(n - 1, maxw, values, weights, dp);
        int take = Integer.MIN_VALUE;
        if (weights.get(n) <= maxw)
            take = values.get(n) + maxCalc(n - 1, maxw - weights.get(n), values, weights, dp);

        return dp[n][maxw] = Math.max(take, nottake);
//        int[][] dp=new int[n][maxw+1];
//        for(int i=weights.get(0);i<=maxw;i++)
//            dp[0][i]=values.get(0);
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j <= maxw; j++) {
//                int nottake=dp[i-1][j];
//                int take=Integer.MIN_VALUE;
//                if(j>=weights.get(i))
//                    take=values.get(i)+dp[i-1][j-weights.get(i)];
//
//                dp[i][j]=Math.max(take,nottake);
//            }
//        }
//        return dp[n-1][maxw];
//    }

    }
}
