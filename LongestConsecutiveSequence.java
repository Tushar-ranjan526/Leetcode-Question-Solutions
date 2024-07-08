package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums={100,200,1,3,2};
        System.out.println(retSequence(nums));
    }
    public static int retSequence(int[] nums){
            int n=nums.length;
            if(n==0) return 0;
            int longest=1;
            Set<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            set.add(nums[i]);
        }
        for(int it:set){
            if(!set.contains(it-1)){
                int count=1;
                int x=it;
                while(set.contains(x+1)){
                    count++;
                    x=x+1;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
        }
}
