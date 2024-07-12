package Leetcode;

public class SringArrayEqual {
    public static void main(String[] args) {
        String[] word1={"a", "cb"};
        String[] word2={"ab", "c"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int wd1=0,wd2=0;
        int i=0,j=0;
        while(wd1<word1.length && wd2<word2.length){
            if(word1[wd1].charAt(i)!=word2[wd2].charAt(j))return false;
            i++;j++;
            if(i==word1[wd1].length()){
                wd1++;i=0;
            }
            if(j==word2[wd2].length()){
                wd2++;j=0;
            }
        }
        if(wd1==word1.length && wd2==word2.length)
        return true;

        return false;
    }
}
