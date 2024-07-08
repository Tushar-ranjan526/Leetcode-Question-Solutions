package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxSubarray {
    public static void main(String[] args) {
        int[] arr={1,5,3,2,6,7,6};
        System.out.println(sumOfMax(arr,3));

    }
    public static List<Integer> sumOfMax(int[] nums,int k){
        int i=0,j=0,sum=0,max=0;
        List<Integer> list=new ArrayList<>();
        while(j<nums.length){
           sum+=nums[j];
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                max=Math.max(max,sum);
                list.add(max);
                sum-=nums[i];
                i++;
                j++;
            }
        }
        return list;
    }
}
