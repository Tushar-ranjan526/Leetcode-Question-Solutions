package Leetcode;

import java.util.Arrays;

public class LengthofLastWord {
    public static void main(String[] args) {
//        lengthOfWord("   fly me   to   the moon  ");
        System.out.println(lengthOfWord("   fly me   to   the moon  "));
    }
    public static int lengthOfWord(String s){
        String[] str=s.split(" ");
        String last=str[str.length-1];
        return last.length();
    }
}
