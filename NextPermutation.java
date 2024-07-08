package Leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums={2,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
            int i=-1;
        for (int j = nums.length-2; j>=0 ; j--) {
            if(nums[j]<nums[j+1]){
                i=j;
                break;
            }
        }
        if(i==-1){
            Arrays.sort(nums);
            return;
        }
        changeArray(nums,i);
        Arrays.sort(nums,i+1,nums.length);
    }
    public static void changeArray(int[] nums,int i){
        int min=Integer.MAX_VALUE,curr=nums[i],ind=-1;
        for (int j = i+1; j < nums.length ; j++) {
            if(min>nums[j] && nums[j]>curr){
                min=nums[j];
                ind=j;
            }
        }
        swap(nums,i,ind);
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
}
