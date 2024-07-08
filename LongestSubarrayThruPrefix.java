package Leetcode;

import java.util.HashMap;

public class LongestSubarrayThruPrefix {
    public static void main(String[] args) {
        int[] nums={1,2,1,0,1};
        System.out.println(longestSubarraySum(nums,4));
    }
    public static int longestSubarraySum(int[] nums,int k){
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int len=0,sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if(sum==k) len=Math.max(len,i+1);
            int tofind=sum-k;
            if(mpp.containsKey(tofind)){
                int leng=i-mpp.get(tofind);
                len=Math.max(len,leng);
            }
            if(!mpp.containsKey(tofind)){
                mpp.put(sum,i);
            }

        }
        return len;
    }
}
