package Leetcode;


public class Rotating2DArray {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        print2DArray(matrix);
        System.out.println("");
        rotateArray(matrix);
        print2DArray(matrix);
    }

    private static void print2DArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static void rotateArray(int[][] matrix) {
        if(matrix.length==0){
            return;
        }
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                transpose(matrix,i,j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            reverseArray(matrix[i]);
        }
    }

    private static void prin1DtArray(int[] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            System.out.print(matrix[i]+" ");

        }
    }

    private static void reverseArray(int[] matrix) {
        int i=0,j=matrix.length-1;
        while(i<j){
            swap(matrix,i,j);
            i++;
            j--;
        }
    }
    public static void swap(int[] matrix,int i,int j){
        int temp=matrix[i];
        matrix[i]=matrix[j];
        matrix[j]=temp;
    }
    private static void transpose(int[][] matrix, int i, int j) {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

}
