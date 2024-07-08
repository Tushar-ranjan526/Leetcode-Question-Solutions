package Leetcode;

public class LongestSubarrayWithSumk {
    public static void main(String[] args) {
        int[] nums={1,2,3,1,1,1,1};
        System.out.println(sumK(nums,3));
    }
    public static int sumK(int[] nums,int k){
        int maxlen=0,sum=0,i=0,j=0;
        while(j<nums.length){
            while(sum>k && i<=j){
                sum-=nums[j];
                i++;
            }
            if(sum==k){
                maxlen= Math.max(maxlen,j-i+1);
            }
            j++;
            if(j<nums.length)
                sum+=nums[j];
        }
        return maxlen;
    }
}
