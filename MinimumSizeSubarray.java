package Leetcode;

public class MinimumSizeSubarray {
    public static void main(String[] args) {
        int[] nums={1,4,4};
        System.out.println(minSubArrayLen(4,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int i=0,j=0,sum=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                int len=j-i+1;
                minlen=Math.min(minlen,len);
                sum-=nums[i];
                i++;
            }
            if(j<nums.length)j++;
        }
        if(minlen==Integer.MAX_VALUE)return 0;
        return minlen;
    }
}
