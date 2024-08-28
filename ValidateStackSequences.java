package Leetcode;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed={4,0,1,2,3};int[] popped={4,2,3,0,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0,j=0;
        stack.push(pushed[i]);
        i++;
        if(stack.peek()==popped[j]){
            stack.pop();
            j++;
        }
        while(i<pushed.length){
            stack.push(pushed[i]);
            i++;
            while(!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty())return true;
        return false;
    }
}
