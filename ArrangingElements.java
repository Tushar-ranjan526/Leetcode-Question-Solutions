package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrangingElements {
    public static void main(String[] args) {
        int[] nums={3,1,-2,5,-1,-4};
        int[] arr=arrange(nums);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] arrange(int[] nums) {
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0)
                neg.add(nums[i]);
            else
                pos.add(nums[i]);
        }
        if(neg.size()<pos.size()){
            for (int i = 0; i <neg.size() ; i++) {
                nums[2*i]=pos.get(i);
                nums[2*i+1]=neg.get(i);
            }
            int index=neg.size()*2;
            for (int i = neg.size(); i <pos.size() ; i++) {
                nums[index++]=pos.get(i);
            }

        }else{
            for (int i = 0; i <pos.size() ; i++) {
                nums[2*i]=pos.get(i);
                nums[2*i+1]=neg.get(i);
            }
            int index=pos.size()*2;
            for (int i = pos.size(); i <neg.size() ; i++) {
                nums[index++]=neg.get(i);
            }
        }

        return nums;
    }
}
