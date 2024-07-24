package Leetcode;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FlaG"));
    }
    public static boolean detectCapitalUse(String word) {
        if(check(word,'A','Z') || check(word,'a','z') || check(word.substring(1),'a','z')){
            return true;
        }
        return false;
    }

    private static boolean check(String word,char start,char end) {
        for (char ch:word.toCharArray()) {
            if(ch<start || ch>end)return false;
        }
        return true;
    }

}
