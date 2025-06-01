import java.util.Arrays;

public class LexicographicallyLargestValidSqnc {
    public static void main(String[] args) {
        LexicographicallyLargestValidSqnc ls=new LexicographicallyLargestValidSqnc();
        int[] ans=ls.constructDistancedSequence(3);
        System.out.println(Arrays.toString(ans));
    }
    public int[] constructDistancedSequence(int n) {
        int[] ans=new int[(n-1*2)+1];
        if(n==1){
            ans[0]=1;
            return ans;
        }
        retDistancedSequence(1,n,ans);
        return ans;
    }
    public void retDistancedSequence(int i,int n,int[] ans){
        
    }
}
