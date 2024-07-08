package Leetcode;
import java.util.*;
public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int[] nums={3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(list.get(list.size()-1)<nums[i]){
                list.add(nums[i]);
                len++;
            }else{
                int ind=binSearch(list,nums[i]);
                list.set(ind,nums[i]);

            }
            System.out.println(list);
        }
        return len;
    }
    public static int binSearch(List<Integer> list,int tar){
        int s=0,e=list.size()-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(list.get(m)==tar){
                return m;
            }
            else if(list.get(m)>tar){
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return s;
    }
}
