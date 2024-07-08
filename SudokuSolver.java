package Leetcode;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.' },
                {'6','.','.','1','9','5','.','.','.' },
                {'.','9','8','.','.','.','.','6','.' },
                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }

        };
        solveSudoku(board);
        printBoard(board);
    }
    public static void printBoard(char[][] board){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if(board[i][j]=='.'){
                    for (char k = '1'; k <='9' ; k++) {
                        if(valid(board,i,j,k)){
                            board[i][j]=k;
                            if(solve(board))return true;
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid(char[][] board, int row, int col, char k) {
        for (int i = 0; i < board.length; i++) {
                if(board[row][i]==k)return false;
                else if(board[i][col]==k)return false;
                else if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==k)return false;
            }
        return true;
        }

}
