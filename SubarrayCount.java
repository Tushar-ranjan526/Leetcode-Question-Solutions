package Leetcode;

public class SubarrayCount {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subArray(nums,3));
    }
    public static int subArray(int[] nums,int k){
        if(nums.length==0){
            return 0;
        }
        int count=0,i=0,j=0,sum=nums[j];
        while(j<nums.length){
            while(i<=j && sum>k){
                sum-=nums[i++];
            }

            if(sum==k)count++;

            j++;
            if(j<nums.length){
                sum+=nums[j];
            }
        }
        return count;
    }
}
