package Leetcode;

public class ValidMatrixRowColSumGiven {
    public static void main(String[] args) {
        int[] rowSum={5,7,10};
        int[] colSum={8,6,8};
        int[][] ans=restoreMatrix(rowSum,colSum);
        printMatrix(ans);
    }
    public static void printMatrix(int[][] ans){
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j <ans[0].length ; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int[][] ans=new int[rowSum.length][colSum.length];
        for (int i = 0; i <rowSum.length*colSum.length ; i++) {
            int[] row=findMin(rowSum);
            int[] col=findMin(colSum);
            int mini=Math.min(row[0],col[0]);
            if(mini==Integer.MAX_VALUE)return ans;
            ans[row[1]][col[1]]=mini;
            rowSum[row[1]]=row[0]-mini;
            colSum[col[1]]=col[0]-mini;
        }
        return ans;
    }
    public static int[] findMin(int[] arr){
        int mini=Integer.MAX_VALUE,ind=-1;
        for (int i = 0; i < arr.length; i++) {
            if(mini>arr[i] && arr[i]!=0){
                mini=arr[i];
                ind=i;
            }
        }
        return new int[]{mini, ind};
    }
}
