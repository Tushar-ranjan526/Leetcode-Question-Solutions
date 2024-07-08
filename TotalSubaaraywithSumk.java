package Leetcode;

public class TotalSubaaraywithSumk {
    public static void main(String[] args) {
        int[] nums={-1,-1,1};
        System.out.println(sumK(nums,0));
    }
    public static int sumK(int[] nums,int k){
        if(nums.length==0){
            return 0;
        }
        int total=0,i=0,j=0,sum=0;
        while(i<nums.length && j<nums.length){
            sum+=nums[j];
            if(sum==k){
                total++;
                sum-=nums[i];
                i++;j++;
            }
            else if(sum<k){
                j++;
            }else{
                sum-=nums[i];
                i++;j++;
            }
            if(j==nums.length-1 && nums[j]==k) {
                total++;
                j++;
            }
        }
        return total;
    }
}
