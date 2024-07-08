package Leetcode;
import java.util.*;
public class Nqueens {
    public static void main(String[] args) {
        char[][] board=new char[5][5];
        List<List<String>> biglist=new ArrayList<>();
        fillboard(board);
        nQueens(0,board,biglist);
        System.out.println(biglist);

    }
    public static void showBoard(char[][] boards,List<List<String>> biglist){
        List<String> ans=new ArrayList<>();
        for (int row = 0; row < boards.length; row++) {
            for (int col = 0; col < boards.length ; col++) {
                if(boards[row][col]=='Q')
                    ans.add("Q");
                else
                    ans.add(".");
            }

        }biglist.add(ans);

    }
    public static void fillboard(char[][] boards){
        for(int row=0;row< boards.length;row++){
            for (int col = 0; col < boards[row].length; col++) {
                boards[row][col]='X';
            }
        }
    }
    public static void nQueens(int col,char[][] board,List<List<String>> biglist){
        if(col==board.length){
            showBoard(board,biglist);
            System.out.println();
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if(isSafe(board,col,row)){
                board[row][col]='Q';
                nQueens(col+1,board,biglist);
                board[row][col]='X';
            }
        }
        return;
    }
    public static boolean isSafe(char[][] boards,int col,int row){
        int duprow=row,dupcol=col;
        while(row>=0 && col>=0){
            if(boards[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(col>=0){
            if(boards[row][col]=='Q') return false;
            col--;
        }
        col=dupcol;
        while(row< boards.length && col>=0){
            if(boards[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }
}
