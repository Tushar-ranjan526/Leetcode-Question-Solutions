public class LongestCommonSupersequence {
    public static void main(String[] args) {
        LongestCommonSupersequence ls=new LongestCommonSupersequence();
        System.out.println(ls.shortestCommonSupersequence("abac","cab"));
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        if(str1.equals(str2)){
            return str1;
        }
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length();i++){
            dp[i][0]=0;
        }
        for(int i=0;i<str2.length();i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int i=str1.length(),j=str2.length();
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(j>0){
            sb.append(str2.charAt(--j));
        }
        while(i>0){
            sb.append(str1.charAt(--i));
        }
        printArray(dp);
        return sb.reverse().toString();
    }

    public void printArray(int[][] dp){
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("");
        }
    }

}
