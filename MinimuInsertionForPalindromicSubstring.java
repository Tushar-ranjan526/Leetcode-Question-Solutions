package Leetcode;

public class MinimuInsertionForPalindromicSubstring {
    public static void main(String[] args) {
        String s="zzazz";
        System.out.println(minInsertions(s));
    }
    public static int minInsertions(String s) {
        StringBuilder s1=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            s1.append(s.charAt(i));
        }
        int pal=retMaxPal(s,s1);
        return s.length()-pal;
    }
    public static int retMaxPal(String s,StringBuilder s1){
        int m=s.length(),n=s1.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m;i++)dp[i][0]=0;
        for(int i=0;i<n;i++)dp[0][i]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s1.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
