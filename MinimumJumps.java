import java.util.Arrays;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr={1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(arr));
    }
    public static int minJumps(int[] arr){
        int[] dp=new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE/100);
        dp[dp.length-1]=0;
        for(int i=arr.length-2;i>=0;i--){
            int totalJumps=arr[i];
            for(int j=1;j<=totalJumps;j++){
                if(i+j>arr.length-1){
                    break;
                }
                dp[i]=Math.min(dp[i],1+dp[i+j]);
            }
        }
        return (dp[0]==Integer.MAX_VALUE/100)?-1:dp[0];
    }
}
