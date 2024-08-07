package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterI {
    public static void main(String[] args) {
        int[] nums1={1,3,5,2,4};
        int[] nums2={6,5,4,3,2,1,7};
        int[] ans=nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> mpp=new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            mpp.put(nums2[i],i);
        }
        int[] nge=new int[nums2.length];
        for (int i = nums2.length-1; i>=0 ; i--) {
            if(stack.isEmpty()){
                stack.push(nums2[i]);
                nge[i]=-1;
            }
            else if(stack.peek()<nums2[i]){
                while(!stack.isEmpty() && stack.peek()<nums2[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(nums2[i]);
                    nge[i]=-1;
                }else{
                    nge[i]=stack.peek();
                    stack.push(nums2[i]);
                }
            }else{
                nge[i]=stack.peek();
                stack.push(nums2[i]);
            }

        }
        int[] ans=new int[nums1.length];
        for (int i = 0; i <nums1.length ; i++) {
            ans[i]=nge[mpp.get(nums1[i])];
        }
        return ans;
    }

}
