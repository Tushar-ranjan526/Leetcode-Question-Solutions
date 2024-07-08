package Leetcode;

public class GoodSubarrays {
    public static void main(String[] args) {
        int[] nums={2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums,2));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int i=0,j=0,subarr=0,cnt=(nums[j]%2!=0)?1:0;
        while(j<nums.length){
            while (cnt<k&&j<nums.length){
                j++;
                if(nums[j]%2!=0)cnt++;
            }
            if(cnt==k){
                subarr++;
                if(nums[i]%2!=0){
                cnt--;
                }else
                i++;
            }
        }
        return subarr;
    }
}
