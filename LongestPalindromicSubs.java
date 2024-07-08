package Leetcode;

public class LongestPalindromicSubs {
    public static void main(String[] args) {
        String s="cbbd";
        longestSubstring(s);
//        System.out.println();
    }
    private static void longestSubstring(String s1) {
        StringBuilder s2=new StringBuilder();
        for (int i = s1.length()-1; i >=0 ; i--) {
            s2.append(s1.charAt(i));
        }

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
        String str=s1.substring(s1.length()-1-maxi,maxi+1);
        System.out.println(str);
//        int i=findIndex(dp,n1,n2,maxi,true);
//        int j=findIndex(dp,n1,n2,maxi,false);

    }
//    public static int findIndex(int[][] dp,int n1,int n2,int maxi,boolean findi){
//        for (int i=0; i <= n1; ++i) {
//            for (int j=0; j <=n2 ; ++j) {
//                if(dp[i][j]==maxi){
//                    if(findi)return i;
//                    else return j;
//                }
//            }
//        }
//        return -1;
//    }
}
