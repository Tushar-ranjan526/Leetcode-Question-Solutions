package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortWithFrequency {
    public static void main(String[] args) {
        int[] nums={1,1,2,2,2,3};
        int[] ans=frequencySort(nums);
        System.out.println(Arrays.toString(ans));
//        frequencySort(nums);
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int num:nums){
           mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        Integer[] temp=new Integer[mpp.size()];
        int i=0;
        for (Integer key:mpp.keySet()) {
            temp[i]=key;
            i++;
        }
        Arrays.sort(temp,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                if(mpp.get(a)==mpp.get(b)){
                    return b - a;
                }
                return mpp.get(a) - mpp.get(b);
            }
        });
        int m=0;
        for(int num:temp){
            int freq=mpp.get(num);
            for (int j=0;j<freq;j++){
                nums[m]=num;
                m++;
            }
        }
        return nums;
    }
}
