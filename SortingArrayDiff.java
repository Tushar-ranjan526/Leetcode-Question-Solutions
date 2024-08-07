package Leetcode;

import java.util.Arrays;

public class SortingArrayDiff {
    public static void main(String[] args) {
        int[] nums={5,1,1,2,0,0};
        int[] ans=sortArray(nums);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] sortArray(int[] nums) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int n=max-min;
        int[] arr=new int[n+1];
        for (int i=0;i<nums.length;i++){
            arr[nums[i]-min]++;
        }
        int ind=0;
        for (int i = 0; i < arr.length; i++) {
            while(arr[i]>0){
                nums[ind]=min;
                ind++;
                arr[i]--;
            }
            min++;
        }
        return nums;
    }
}
