package Leetcode;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("10",2));
    }
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();StringBuilder sb=new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if(stack.isEmpty())stack.push(num.charAt(i));

            else if(stack.peek()-'0'>num.charAt(i)-'0' && k>0){
                while(!stack.isEmpty() && stack.peek()-'0'>num.charAt(i)-'0' && k>0){
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
            }else stack.push(num.charAt(i));
        }
        if(k>0) {
            while (!stack.isEmpty() && k > 0) {
                stack.pop();
                k--;
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        if(!sb.isEmpty()) {
            while (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '0'){
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return (!sb.isEmpty())?sb.reverse().toString():"0";
    }
}
