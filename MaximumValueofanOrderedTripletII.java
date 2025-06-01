import java.util.Arrays;

public class MaximumValueofanOrderedTripletII {
    public static void main(String[] args) {
        MaximumValueofanOrderedTripletII mv2=new MaximumValueofanOrderedTripletII();
        int[] nums={12,6,1,2,7};
        System.out.println(mv2.maximumTripletValue(nums));
    }
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int[] pref=new int[n],suff=new int[n] ;
        int maxi=Integer.MIN_VALUE,mini=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            pref[i]= maxi;
            maxi =Math.max(maxi,nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            suff[i]=mini;
            mini=Math.max(mini,nums[i]);
        }
        long ans=0;
        for(int i=1;i<n-1;i++){
            long mul=(long)(pref[i]-nums[i])*suff[i];
            ans=Math.max(ans,mul);
        }
        return ans;
    }
}
