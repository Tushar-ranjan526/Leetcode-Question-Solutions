package Leetcode;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids={1,-1,-2,-2};
        int[] ans=asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
                if(asteroids[i]>0 || stack.isEmpty()) {
                    stack.push(asteroids[i]);
                }else{
                    while(!stack.isEmpty()){
                        int top=stack.peek();
                        if(top<0){
                            stack.push(asteroids[i]);
                            break;
                        }
                        int modVal=Math.abs(asteroids[i]);
                        if(modVal==top){
                            stack.pop();
                            break;
                        }else if(modVal<top){
                            break;
                        }else{
                            stack.pop();
                            if(stack.isEmpty()){
                               stack.push(asteroids[i]);
                               break;
                            }
                        }
                    }
                }

                }
        int[] ans=new int[stack.size()];
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            ans[i]=stack.pop();
            i--;
        }
        return ans;
    }
}
