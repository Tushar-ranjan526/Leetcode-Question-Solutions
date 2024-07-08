package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSubarrayAlmostUnique {

    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        nums.add(2);
        nums.add(1);
        nums.add(2);
        nums.add(1);
        System.out.println(maxSum(nums,3,3));

    }
    public static long maxSum(List<Integer> nums, int m, int k) {
        long maxi=0,sum=0;
        Map<Integer,Integer> mpp=new HashMap<>();

//        for the first k size subarray.
        for (int i = 0; i < k; i++) {
            mpp.put(nums.get(i),mpp.getOrDefault(nums.get(i),0)+1);
            sum+=nums.get(i);
        }
//        agar map ka size m se bada hua matlab utne unique elements hai
        if(mpp.size()>=m){
            maxi=sum;
        }
        int i=0,j=k;
        while(j<nums.size()){
            //left pointer slide karna
            sum-=nums.get(i);
            mpp.put(nums.get(i),mpp.get(nums.get(i))-1);
            // agar uss element ka occurance 0 hua matlab wo unique tha to map mei se nikalo taaki unique mei na gina jaaye.
            if(mpp.get(nums.get(i))==0)mpp.remove(nums.get(i));
            i++;

            sum+=nums.get(j);
            mpp.put(nums.get(j),mpp.getOrDefault(nums.get(j),0)+1);
            j++;

            if(mpp.size()>=m){
                maxi=Math.max(sum,maxi);
            }
        }
        return maxi;
    }
}

    // question link.
    //https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/description/
