package Leetcode;
import java.util.List;
import java.util.ArrayList;
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4,5,6},
                {20,21,22,23,24,7},
                {19,32,33,34,25,8},

        };
        System.out.println(matrix.length);
//       List<Integer> list= spiralMatrix(matrix);
//        System.out.println(list);
    }

    private static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0){
            return list;
        }
        int top=0,right=matrix.length-1,bottom= matrix.length-1,left=0;
        while (top<=bottom && right>=left){
            for (int i = left; i <=right ; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top<=bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
