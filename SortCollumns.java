package Leetcode;

public class SortCollumns {
    public static void main(String[] args) {
        String[] strs={"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs));
    }
    public static int minDeletionSize(String[] strs) {
        int colCnt=0;
        for (int i = 0; i < strs.length-1; i++) {
            for (int j = 0; j <strs[0].length() ; j++) {
                if((strs[j].charAt(i)-'a')>(strs[j+1].charAt(i)-'a')){colCnt++;break;}
            }
        }
        return colCnt;
    }
}
