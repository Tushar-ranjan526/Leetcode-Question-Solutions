package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SumOfSubarrayMini {
    public static void main(String[] args) {
        int[] nums={71,55,82,55};
        System.out.println(sumSubarrayMins(nums));
    }
    public static int sumSubarrayMins(int[] arr) {
        int[] pse=retPreviousSmaller(arr);
        int[] nse=retNextSmaller(arr);
        int sum=0;
        int mod=(int)Math.pow(10,9)+7;
        for (int i = 0; i <arr.length ; i++) {
            sum=(sum+((i-pse[i])*(nse[i]-i)*arr[i])%mod)%mod;
        }
        return sum;
    }

    private static int[] retNextSmaller(int[] arr) {
        List<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for (int i = arr.length-1; i >=0 ; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            list.add(0,(stack.isEmpty())?arr.length:stack.peek());
            stack.push(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] retPreviousSmaller(int[] arr) {
        List<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            list.add((stack.isEmpty())?-1:stack.peek());
            stack.push(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
