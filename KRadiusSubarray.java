package Leetcode;

import java.util.Arrays;

public class KRadiusSubarray {
    public static void main(String[] args) {
        int[] nums={7,4,3,9,1,8,5,2,6};
        int[] ans=getAverages(nums,3);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] getAverages(int[] nums, int k) {
        int[] ans=new int[nums.length];
        if(k==0 )return nums;
        Arrays.fill(ans,-1);
        if(nums.length<(2*k+1))return ans;
        int left=0,right=2*k;
        int i=k;
        long sum=0;
        for (int j = left; j <= right; j++) {
            sum+=nums[j];
        }
        ans[i]=(int)(sum/(2*k+1));
        i++;
        right++;
        while(right<nums.length){
          int rightside=nums[right];
          int leftside=nums[left];
          sum=sum-leftside+rightside;
          ans[i]=(int)(sum/(2*k+1));
          i++;
          left++;
          right++;
        }
        return ans;

    }
}
