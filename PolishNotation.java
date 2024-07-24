package Leetcode;

import java.util.Stack;

public class PolishNotation {
    public static void main(String[] args) {
        String[] tokens={"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i]!="+" && tokens[i]!="-" && tokens[i]!="*" && tokens[i]!="/" ){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int a=0,b=0;
                if(!stack.isEmpty())b=stack.pop();
                if(!stack.isEmpty())a=stack.pop();
                int ans=performOp(a,b,tokens[i]);
                stack.push(ans);
            }
        }
        return stack.pop();
    }

    private static int performOp(int a, int b, String token) {
        switch (token){
            case "*":
                return a * b;
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "/":
                return a/b;
            default:
                return a*b;
        }
    }
}
