package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FourSum {
    public static void main(String[] args) {
        int[] matrix={1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> list= fourSum(matrix,-294967296);
        System.out.println(list);
    }

    private static List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> bigList=new ArrayList<>();
        int n=nums.length;
        if(n<4) return bigList;
        Arrays.sort(nums);
        for (int i = 0; i <n ; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                if(j > i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=nums.length-1;
                while (k<l){
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum<target) k++;
                    else if(sum>target) l--;
                    else{
                        List<Integer> list=new ArrayList<>();
                        list.add(0,nums[l]);list.add(0,nums[k]);list.add(0,nums[j]);list.add(0,nums[i]);
                        bigList.add(list);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }
            }

        }
        return bigList;
    }
}
