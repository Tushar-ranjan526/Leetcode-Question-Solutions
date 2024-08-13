package Leetcode;

import java.util.*;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> ans=findDuplicates(nums);
        System.out.println(ans);
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0){
                int absval=nums[Math.abs(nums[i])-1];
                ans.add(Math.abs(nums[i]));
            }
            else{
                nums[Math.abs(nums[i])-1]=  -nums[Math.abs(nums[i])-1];
            }
        }
        return ans;
    }
}
