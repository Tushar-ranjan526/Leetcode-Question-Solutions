package Leetcode;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] operations={"5","2","C","D","+"};
        BaseballGame bg=new BaseballGame();
        System.out.println(bg.calPoints(operations));
    }
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String str:operations){
            if(!isSymbol(str)){
                stack.push(Integer.parseInt(str));
            }else{
                switch(str){
                    case "+":
                        Integer n1=stack.pop();
                        Integer n2=stack.pop();
                        stack.push(n2);
                        stack.push(n1);
                        stack.push(n1+n2);
                        break;
                    case "C":
                        Integer n3=stack.pop();
                        break;
                    case "D":
                        Integer n4=stack.peek();
                        stack.push(2*n4);
                        break;
                    default:
                        return 0;
                }
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
    public boolean isSymbol(String s){
        if(s.equals("C") || s.equals("D") || s.equals("+"))return true;
        else return false;
    }
}
