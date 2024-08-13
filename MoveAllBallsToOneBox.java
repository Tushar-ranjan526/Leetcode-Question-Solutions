package Leetcode;

import java.util.Arrays;

public class MoveAllBallsToOneBox {
    public static void main(String[] args) {
        int[] ans=minOperations("110");
        System.out.println(Arrays.toString(ans));
    }
    public static int[] minOperations(String boxes) {
        int totalBallsRight=0,totalOpNeedRight=0,totalBallsLeft=0,totalOpNeedLeft=0;
        char[] charArr=boxes.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i]=='1'){
                totalBallsRight++;
                totalOpNeedRight+=i;
            }
        }
        int[] ans=new int[charArr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=totalOpNeedLeft+totalOpNeedRight;
            totalOpNeedLeft+=totalBallsLeft;
            if(charArr[i]=='1'){
                totalBallsRight--;
                totalBallsLeft++;
                totalOpNeedLeft++;
            }
            totalOpNeedRight-=totalBallsRight;
        }
        return  ans;
    }
}
