package Leetcode;

public class MaximumAreaOfOnes {
    public static void main(String[] args) {
        int[][] grid={
                {0,0},
                {1,0}
        };
        System.out.println(calculateMxiumumArea(grid));
    }

    private static int calculateMxiumumArea(int[][] grid) {
        int minh=Integer.MAX_VALUE,maxh=Integer.MIN_VALUE,minw=Integer.MAX_VALUE,maxw=Integer.MIN_VALUE;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                 if(grid[i][j]==1){
                     minh=Math.min(i,minh);
                     minw=Math.min(minw,j);
                     maxh=Math.max(i,maxh);
                     maxw=Math.max(j,maxw);
                 }
            }

        }
        return (maxw-minw+1)*(maxh-minh+1);
    }
}
