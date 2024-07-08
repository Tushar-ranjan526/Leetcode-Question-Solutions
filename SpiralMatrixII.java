package Leetcode;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] nums=generateMatrix(0);
        printArray(nums);
    }
    public static int[][] generateMatrix(int n){
        int[][] nums=new int[n][n];
        int top=0,right=n-1;
        int bottom=n-1,left=0;
        int i=1;
        while(top<=bottom && left<=right && i<=n*n){
            for (int j = left; j <=right ; j++) {
                nums[top][j]=i;
                i++;
            }
            top++;
            for(int j=top;j<=bottom;j++){
                nums[j][right]=i;
                i++;
            }
            right--;
            if(top<=bottom){
                for (int j = right; j >=left ; j--) {
                    nums[bottom][j]=i;
                    i++;
                }
                bottom--;
            }
            if(left<=right){
                for (int j = bottom; j >=top ; j--) {
                    nums[j][left]=i;
                    i++;
                }
                left++;
            }
        }
        return nums;
    }
    public static void printArray(int[][] nums){
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums[i].length ; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
}
