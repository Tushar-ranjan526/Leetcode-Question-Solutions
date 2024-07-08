package Leetcode;

public class UniquePAths {
    public static void main(String[] args) {
        System.out.println(findPath(2,4));
    }
    public static int findPath(int m,int n){
        return totalPath(m,n,0,0);
    }
    static int cnt1=0,cnt2=0,cnt3=0;
    public static int totalPath(int rows,int cols,int r,int c){
        if(r==rows && c==cols){
            return 1;
        }

        if(r<rows && c<cols){
            cnt1+=totalPath(rows,cols,r+1,c+1);
        }
        else if(r<rows){
            cnt2+=totalPath(rows,cols,r+1,c);
        }
        else if(c<cols){
            cnt3+=totalPath(rows,cols,r,c+1);
        }
        return cnt1+cnt2+cnt3;
    }
}
