package Leetcode;
import java.util.*;
public class PowerOfKSizeSubarray {
    public static void main(String[] args) {
        PowerOfKSizeSubarray ps=new PowerOfKSizeSubarray();
        int[] nums={3,2,3,2,3,2};
       int[] ans=ps.resultsArray(nums,2);
        System.out.println(Arrays.toString(ans));
    }
    public int[] resultsArray(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        int j=0;
        for(int i=0;i<nums.length-k+1;i++){
            boolean sorted=ifSorted(Arrays.copyOfRange(nums,i,i+k));
            if(sorted){
                ans[j]=nums[i+k-1];
            }else{
                ans[j]=-1;
            }
            j++;
        }
        return ans;
    }
    public boolean ifSorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])return false;
        }
        return true;
    }
}
