package Leetcode;

import java.util.*;

public class CloseStrings {
    public static void main(String[] args) {
        System.out.println(closeStrings("aaabbbbccddeeeeefffff","aaaaabbcccdddeeeeffff"));
//        closeStrings("abc","bca");
    }
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false;
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for (int i=0;i<word1.length();i++) {
            freq1[word1.charAt(i)-'a']++;
        }
        for (int i=0;i<word2.length();i++) {
            freq2[word2.charAt(i)-'a']++;
        }
        for (int i = 0; i < freq1.length; i++) {
            if((freq1[i]==0 && freq2[i]!=0)||(freq1[i]!=0 && freq2[i]==0))return false;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < freq1.length; i++) {
            if(freq1[i]!=freq2[i])return false;
        }
        return true;
    }
}
