package Leetcode;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(retConsecutiveOnes(nums,3));
    }
    public static int retConsecutiveOnes(int[] nums,int k){
        int l=0,r=0;int maxlen=0,zeroes=0;
        while(r< nums.length){
            if(nums[r]==0)
                zeroes++;
           if(zeroes>k){
               if(nums[l]==0) zeroes--;
               l++;
           }
           if(zeroes<=k){
               maxlen=Math.max(maxlen,r-l+1);
           }
            r++;
        }
        return maxlen;
    }
}
