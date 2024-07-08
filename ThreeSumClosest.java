package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums={0,1,2};
        System.out.println(threeSumClose(nums,3));
    }
    public static int threeSumClose(int[] nums,int target){
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<target){
                    list.add(sum);
                    j++;
                }
                else if(sum>target){
                    list.add(sum);
                    k--;
                }
                else{
                    return sum;
                }

            }

        }
        int min=Integer.MAX_VALUE;
        int ind=0;
        for (int i = 0; i < list.size(); i++) {
            if(min>Math.abs(target-list.get(i))){
                min=Math.abs(target-list.get(i));
                ind=i;
            }
        }
        return list.get(ind);
    }
}
