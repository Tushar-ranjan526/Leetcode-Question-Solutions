package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] nums={10,24,12,3,0,6};
        List<Integer> list=searchLeader(nums);
        System.out.println(list);
    }

    private static List<Integer> searchLeader(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int j=nums.length-1;
        int leader=nums[j];
        list.add(0,nums[j]);
        while(j>=0){
            if(nums[j]>leader){
                leader=nums[j];
                list.add(0,leader);
            }
            j--;
        }
        return list;
    }
}
