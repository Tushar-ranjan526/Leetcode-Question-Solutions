package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSubsequence {
    public static void main(String[] args) {
        int[] nums={-1,-2,3,4};
        int k= 3;
        int[] ans=maxSubsequence(nums,k);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] maxSubsequence(int[] nums, int k) {
        int i=0,j=0,sum=0,maxsum=Integer.MIN_VALUE,index=-1;
        Map<Integer,Integer> mpp=new HashMap<>();
        for (int l = 0; l <nums.length ; l++) {
            mpp.put(nums[l],l);
        }
        Arrays.sort(nums);
        while(j<nums.length){
            sum+=nums[j];
            while(j-i+1>k){
                sum-=nums[i];
                i++;
            }
            if(j-i+1==k){
                if(sum>maxsum){
                    maxsum=sum;
                    index=i;
                }
            }

            if(j<nums.length)j++;
        }
        while(k!=0){

        }
        int[] ans=new int[k];
        int m=0;
        for(int n=index;n<index+k;n++){
            ans[m]=nums[n];
            m++;
        }
        return ans;
    }
}
