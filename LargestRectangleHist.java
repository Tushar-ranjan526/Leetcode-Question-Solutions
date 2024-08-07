package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LargestRectangleHist {
    public static void main(String[] args) {
        int[] heights={1,0,0,1,0,1,0,0,0,1};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxHeight=Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i]){
                stack.push(i);
            }
            else if(heights[stack.peek()]>heights[i]){
                while(!stack.empty() && heights[stack.peek()]>heights[i]){
                    int curr=heights[stack.pop()];
                    int pse=(!stack.isEmpty())?stack.peek():-1;
                    int nse=i;
                    int height=curr*(nse-pse-1);
                    maxHeight=Math.max(height,maxHeight);
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int curr=heights[stack.pop()];
            int pse=(!stack.isEmpty())?stack.peek():-1;
            int nse=heights.length;
            int height=curr*(nse-pse-1);
            maxHeight=Math.max(height,maxHeight);
        }
        return maxHeight;
    }
}
