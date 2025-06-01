import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}
public class SnakeAndLadder {
    public static void main(String[] args) {
        SnakeAndLadder sl=new SnakeAndLadder();
        int[][] board={{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}
                ;
        System.out.println(sl.snakesAndLadders(board));
    }
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(1);
        int steps=0;
        visited[n-1][0]=true;
        while(!queue.isEmpty()){
            int level=queue.size();
            for(int i=0;i<level;i++){
                int curr=queue.poll();
                if(curr==n*n) {
                    return steps;
                }
                for(int j=1;j<=6;j++){
                    int val=curr+j;
                    if(val>n*n)break;
                    int[] cord=getCord(val,board);
                    int r=cord[0],c=cord[1];
                    if(visited[r][c])continue;
                    visited[r][c]=true;
                    if(board[r][c]==-1) {
                        queue.offer(val);
                    }
                    else{
                        queue.offer(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public int[] getCord(int nums,int[][] board){
        int n=board.length,m=board[0].length;
        int from_top_row=(nums-1)/n,row=(n-1)-from_top_row;

        int from_top_col=(nums-1)%m,from_bottom_col=(m-1)-from_top_col;
        int currow=n-row;
        int col=(currow%2==0)?(from_bottom_col):from_top_col;
        return new int[]{row,col};
    }
}
