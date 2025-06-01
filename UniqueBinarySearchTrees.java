import java.util.Arrays;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees ut=new UniqueBinarySearchTrees();
        System.out.println(ut.numTrees(19));
    }
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        return retTrees(n,dp);
    }
    public int retTrees(int n,int[] dp){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            ans+=numTrees(i-1)*numTrees(n-i);
        }
        return dp[n]=ans;
    }
}
