package Leetcode;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix={
                {-19,57},
                {-40,-5}
        };
        int m=matrix.length;
        int mini=Integer.MAX_VALUE;
        int[][] dp=new int[m][m];
        for (int i = 0; i < m; i++) {
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<matrix.length;i++){
            for (int j = 0; j < matrix.length; j++) {
                int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                int d=matrix[i][j]+dp[i-1][j];
                if(j-1>=0)
                    left=matrix[i][j]+dp[i-1][j-1];
                if(j+1<m)
                    right=matrix[i][j]+dp[i-1][j+1];

                dp[i][j]=Math.min(Math.min(d,left),right);
            }
        }
        for (int i = 0; i < dp.length ; i++) {
            mini=Math.min(dp[m-1][i],mini);
        }
        System.out.println(mini);
    }


}
