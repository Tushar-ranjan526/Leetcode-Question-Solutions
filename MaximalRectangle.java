package Leetcode;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        char[][] preSum=retPreMatrix(matrix);
        int maxi=Integer.MIN_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            int ans=largestRectangleArea(preSum[i]);
            maxi=Math.max(ans,maxi);
        }
        return maxi;
    }
    public static int largestRectangleArea(char[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxHeight=Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()]-'0'<=heights[i]-'0'){
                stack.push(i);
            }
            else if(heights[stack.peek()]-'0'>heights[i]-'0'){
                while(!stack.empty() && heights[stack.peek()]-'0'>heights[i]-'0'){
                    int curr=heights[stack.pop()]-'0';
                    int pse=(!stack.isEmpty())?stack.peek():-1;
                    int nse=i;
                    int height=curr*(nse-pse-1);
                    maxHeight=Math.max(height,maxHeight);
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int curr=heights[stack.pop()]-'0';
            int pse=(!stack.isEmpty())?stack.peek():-1;
            int nse=heights.length;
            int height=curr*(nse-pse-1);
            maxHeight=Math.max(height,maxHeight);
        }
        return maxHeight;
    }
    private static char[][] retPreMatrix(char[][] matrix) {
        char[][] ans=new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int pre = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == '1') {
                    ans[j][i]=(char)((1+pre)+'0');
                    pre++;
                }else{
                    ans[j][i]='0';
                    pre=0;
                }
            }
        }
        return ans;
    }
}
