package Leetcode;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board={
                {'a'}
        };
        System.out.println(exist(board,"a"));
    }
    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
             if(wordSearch(0,i,j,board,word))return true;
            }
        }
        return false;
    }

    private static boolean wordSearch(int i,int r, int c, char[][] board, String word) {
        if(i==word.length())return true;
        if(r<0 || c<0 ||r>=board.length || c>=board[0].length)return false;
        if(board[r][c]=='#'||board[r][c]!=word.charAt(i))return false;
        char temp;
        boolean up=false,left=false,right=false,down=false;
        temp=board[r][c];
        board[r][c]='#';
            up=wordSearch(i+1,r-1,c,board,word);
            down=wordSearch(i+1,r+1,c,board,word);
            left=wordSearch(i+1,r,c-1,board,word);
            right=wordSearch(i+1,r,c+1,board,word);
            if(up||left||right||down||temp==word.charAt(i))return true;
            board[r][c]=temp;
            return false;
    }
}
