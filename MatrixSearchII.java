package Leetcode;

public class MatrixSearchII {
    public static void main(String[] args) {
        int[][] matrix={
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
//                {1,4},
//                {2,5}
        };
        System.out.println(searchMatrix(matrix,5));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
       int s=0,e=matrix[0].length-1;
       while(s<matrix.length && e>=0){
           if(matrix[s][e]==target)return true;
           else if(matrix[s][e]<target)s++;
           else if(matrix[s][e]>target)e--;
       }
       return false;
    }
}
