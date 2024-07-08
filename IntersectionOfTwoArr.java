package Leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArr {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] arr=retInter(nums1,nums2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] retInter(int[] nums1,int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> list=new ArrayList<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]) i++;
            else if(nums2[j]<nums1[i]) j++;
            else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] arr=new int[list.size()];
        for (int k = 0; k < arr.length; k++) {
            arr[k]=list.get(k);
        }
        return arr;
    }
}
