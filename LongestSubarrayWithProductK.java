package Leetcode;

public class LongestSubarrayWithProductK {
    public static void main(String[] args) {
        int[] nums={10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums,100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int total=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<k)total++;
        }
        int i=0,j=1,product=nums[i];
        while(j<nums.length){
            product*=nums[j];
            if(product<k){
                total++;
            }
            while(product>=k){
                product/=nums[i];
                i++;
            }
            if(j<nums.length)j++;
        }
        return total;
    }
}
