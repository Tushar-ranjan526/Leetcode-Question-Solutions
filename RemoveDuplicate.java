package Leetcode;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2};
        int k=removeDup(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]+",");
        }
    }
    public static int removeDup(int[] nums){
        if(nums.length==0 || nums.length==1) return 0;
        int i=0,j=1,count=1;
        while(j<nums.length && i<nums.length){

            if(nums[i]==nums[j]){
               j++;
            }
            else{
                i++;
               swap(nums,i,j);
               j++;
               count++;
            }
        }
        return count;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
