package Leetcode;

import java.util.Arrays;

public class MinRotatedArr {
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(searchArr(nums));
    }
    public static int searchArr(int[] nums){
        if(nums.length==1) return nums[0];
        int s=0,e=nums.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(nums[s]<nums[e]){
                return nums[0];
            }
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]>nums[s]){
                s=mid+1;
            }else{
                e=mid;
            }
        }
        return Integer.MAX_VALUE;
    }
}
