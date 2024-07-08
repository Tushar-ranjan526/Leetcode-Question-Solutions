package Leetcode;
import java.util.*;
public class ReturnPalindrome {
    public static void main(String[] args) {
        String s="bcbc";
        System.out.println(palindromeIndex(s));
    }
    public static int palindromeIndex(String s) {
        boolean isPal=isPalindrome(s);
        if(isPal)return -1;
        for(int i=0;i<s.length();i++){
            String str=s.substring(0,i)+s.substring(i+1);
            boolean checkPal=isPalindrome(str);
            if(checkPal)return i;
        }
    return -1;
    }
    public static boolean isPalindrome(String str){
        int s=0,e=str.length()-1;
        while(s<str.length()/2){
            if(str.charAt(s)!=str.charAt(e))return false;
            s++;e--;
        }
        return true;
    }
}
