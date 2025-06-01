import java.util.Arrays;

public class SumOfBeautyInArra {
    public static void main(String[] args) {
        SumOfBeautyInArra sa=new SumOfBeautyInArra();
        int[] nums={3,2,1};
        System.out.println(sa.sumOfBeauties(nums));
    }
    public int sumOfBeauties(int[] nums) {
        int n=nums.length;
        int[] pref=new int[n],suff=new int[n];
        int maxi=-1,mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            pref[i]= maxi;
            maxi =Math.max(maxi,nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            suff[i]=mini;
            mini=Math.min(mini,nums[i]);
        }
        int ans=0;
        for(int i=1;i<n-1;i++) {
            int num = nums[i];
            if (num > pref[i] && num < suff[i]) {
                ans += 2;
            } else if (num > nums[i - 1] && num < nums[i + 1]) {
                ans += 1;
            }
        }

        return ans;
    }
}
