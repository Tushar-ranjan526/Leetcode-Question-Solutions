package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterII {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3};
        int[] ans=nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=2*n-1;i>=0;i--) {
            if (stack.isEmpty()) {
                stack.push(nums[i % n]);
                if (i < n) ans[i] = -1;
            } else if (stack.peek() <= nums[i % n]) {
                while (!stack.isEmpty() && stack.peek() <= nums[i % n]) stack.pop();
                if (stack.isEmpty()) {
                    if (i < n) ans[i] = -1;
                    stack.push(nums[i % n]);
                    continue;
                }
                if(i<n) ans[i]=stack.peek();
                stack.push(nums[i % n]);
            } else {
                if (i < n) ans[i] = stack.peek();
                stack.push(nums[i % n]);
            }
        }
        return ans;
    }
}
