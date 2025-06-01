import java.util.Arrays;

public class NumberOfWaysToSplitArray {
    public static void main(String[] args) {
        NumberOfWaysToSplitArray ns=new NumberOfWaysToSplitArray();
        int[] nums={10,4,-8,7};
        System.out.println(ns.waysToSplitArray(nums));
    }
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long sum=0;
        long[] prefixsum=new long[n];
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefixsum[i]=sum;
        }
        int ans=0;
        for(int i=0;i<n-1;i++){
            long sumuptoi=prefixsum[i];
            long sumexcludingi=prefixsum[n-1]-sumuptoi;
            if(sumuptoi>=sumexcludingi)ans++;
        }
        return ans;
    }
}
