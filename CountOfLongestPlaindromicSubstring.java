public class CountOfLongestPlaindromicSubstring {
    public static void main(String[] args) {
        CountOfLongestPlaindromicSubstring cs=new CountOfLongestPlaindromicSubstring();
        String s1="babad";
        String s2="dabab";
        int i=s1.length()-1;
        int j=s2.length()-1;
        System.out.println(cs.longestPalindrome(i,j,s1,s2));
    }
    public int longestPalindrome(int i,int j,String s1,String s2){
        if(i==0 && j==0){
            if(s1.charAt(i)==s2.charAt(j)){
                return 1;
            }
            return 0;
        }
        if(i<0 || j<0){
            return 0;
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+longestPalindrome(--i,--j,s1,s2);
        }else{
            ans+=Math.max(longestPalindrome(--i,j,s1,s2),longestPalindrome(i,--j,s1,s2));
        }
        return ans;
    }
}
