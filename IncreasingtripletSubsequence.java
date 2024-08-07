package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class IncreasingtripletSubsequence {
    public static void main(String[] args) {
        int[] nums={2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        int[] sm=new int[nums.length];
        int[] la=new int[nums.length];
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            if(mini>nums[i])mini=nums[i];
            sm[i]=mini;
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            if(maxi<nums[i])maxi=nums[i];
            la[i]=maxi;
        }
        System.out.println(Arrays.toString(sm));
        System.out.println(Arrays.toString(la));
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>sm[i] && nums[i]<la[i])return true;
        }
        return false;
    }
}
