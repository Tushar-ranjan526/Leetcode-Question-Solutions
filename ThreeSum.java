package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
     int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> list =threeSum(nums);
        System.out.println(list);

    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> bigList=new ArrayList<>();

        int n=nums.length;
        if (n<3) return bigList;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    List<Integer> list=new ArrayList<>();
                    list.add(0,nums[k]);list.add(0,nums[j]);list.add(0,nums[i]);
                    bigList.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return bigList;
    }

}
