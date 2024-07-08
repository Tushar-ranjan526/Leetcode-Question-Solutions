package Leetcode;

public class NoOfIslands {
    public static void main(String[] args) {
        char[][] grid={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int num=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if(grid[i][j]=='1'){
                    num++;
                    retNumber(grid,i,j,grid.length,grid[0].length);
                }
                else continue;
            }
        }
        return num;
    }
    public static void retNumber(char[][] grid,int r,int c,int m,int n){
        if(r<0 || c<0 || r>=m || c>=n)return;
        if(grid[r][c]=='0' || grid[r][c]=='#')return;
        grid[r][c]='#';
        retNumber(grid,r-1,c,m,n);
        retNumber(grid,r,c-1,m,n);
        retNumber(grid,r+1,c,m,n);
        retNumber(grid,r,c+1,m,n);
    }
}
