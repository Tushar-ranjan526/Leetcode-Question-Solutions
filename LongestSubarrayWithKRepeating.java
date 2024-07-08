package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithKRepeating {
    public static void main(String[] args) {
        int[] nums={5,5,5,5,5,5,5};
        System.out.println(maxSubarrayLength(nums,
                4));
    }
    public static int maxSubarrayLength(int[] nums, int k) {
        int maxlen=0,i=0,j=0,faulty=-1;
        boolean shrink=false;
        Map<Integer,Integer> mpp=new HashMap<>();
        while(j<nums.length){
            if(mpp.containsKey(nums[j])){
                if(mpp.get(nums[j])<k){
                    mpp.put(nums[j],mpp.getOrDefault(nums[j],0)+1);
                }else{
                    faulty=nums[j];
                    mpp.put(nums[j],mpp.getOrDefault(nums[j],0)+1);
                    shrink=true;
                }
            }else{
                mpp.put(nums[j],1);
            }
            while(shrink){
                if(nums[i]==faulty){
                    mpp.put(nums[i],mpp.get(nums[i])-1);
                    i++;
                    shrink=false;
                }else{
                    mpp.put(nums[i],mpp.get(nums[i])-1);
                    i++;
                }
            }
            maxlen=Math.max(maxlen,j-i+1);
            if(j<nums.length)j++;
        }
        return maxlen;
    }
}
