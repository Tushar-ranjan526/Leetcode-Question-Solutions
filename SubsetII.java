package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        int[] nums={1,2,2};
        List<List<Integer>> biglist=subsetsWithDup(nums);
        System.out.println(biglist);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> biglist=new ArrayList<>();
        Arrays.sort(nums);
        calcSubsets(0,nums,biglist,list);
        return biglist;
    }

    private static void calcSubsets(int i, int[] nums, List<List<Integer>> biglist, List<Integer> list) {
        if(i==nums.length){
            if(!biglist.contains(list)){
                biglist.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        list.add(nums[i]);
        calcSubsets(i+1,nums,biglist,list);
        list.removeLast();
        calcSubsets(i+1,nums,biglist,list);
    }

}
