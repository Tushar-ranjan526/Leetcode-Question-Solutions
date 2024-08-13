package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
    public static void main(String[] args) {
        int[] nums={-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l={0,1,6,4,8,7};
        int[] r={4,4,9,7,9,10};
        List<Boolean> list=checkArithmeticSubarrays(nums,l,r);
        System.out.println(list);
    }
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            boolean isArithematic=true;
            int[] subarray= Arrays.copyOfRange(nums,l[i],r[i]+1);
            if(subarray.length<=1){
                ans.add(false);
                break;
            }
            Arrays.sort(subarray);
            int diff=subarray[1]-subarray[0];
            for (int j = 1; j <subarray.length-1 ; j++) {
                if(subarray[j+1]-subarray[j]!=diff)isArithematic=false;
            }
            ans.add(isArithematic);
        }
        return ans;
    }
}
