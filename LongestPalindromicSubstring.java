public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring ls=new LongestPalindromicSubstring();
        System.out.println(ls.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        Boolean[][] dp=new Boolean[s.length()][s.length()];
        int sp=-1,ep=-1,len=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(isPalindrome(i,j,s,dp) && len<(j-i+1)){
                    sp=i;
                    ep=j;
                    len=j-i+1;
                }
            }
        }
        return s.substring(sp,ep+1);
    }
    public boolean isPalindrome(int i,int j,String s,Boolean[][] dp){
        if(i>j)return true;
        if(dp[i][j]!=null)return dp[i][j];

        if(s.charAt(i)==s.charAt(j)){
            dp[i][j]=isPalindrome(i+1,j-1,s,dp);
        }else{
            dp[i][j]=false;
        }
        return dp[i][j];
    }
}
