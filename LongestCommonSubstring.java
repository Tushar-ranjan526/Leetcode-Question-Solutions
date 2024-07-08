package Leetcode;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1="wasdijkl";
        String s2="wsdjkl";
        System.out.println(longestSubstring(s1,s2));
    }

    private static int longestSubstring(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        int[][]dp=new int[n1+1][n2+1];
        for(int i=0;i<n1+1;i++)dp[i][0]=0;
        for (int i = 0; i < n2+1; i++) dp[0][i]=0;
        int maxi=Integer.MIN_VALUE;
        for (int i = 1; i <=n1 ; i++) {
            for (int j = 1; j <=n2 ; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    maxi=Math.max(maxi,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return maxi;
    }
}
