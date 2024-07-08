package Leetcode;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums={3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
            int fast=0,slow=0;
            do{
                slow=nums[slow];
                fast=nums[nums[fast]];
            }while(fast!=slow);
            slow=0;
            while(fast!=slow){
                slow=nums[slow];
                fast=nums[fast];
            }
            return slow;
    }
    //question link.
    // https://leetcode.com/problems/find-the-duplicate-number/submissions/1307259227
}
