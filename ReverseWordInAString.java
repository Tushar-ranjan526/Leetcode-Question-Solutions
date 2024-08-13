package Leetcode;

import java.util.Arrays;

public class ReverseWordInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello   world  "));
    }
    public static String reverseWords(String s) {
        int i=0,j=s.length()-1;
        while(s.charAt(i)==' ')i++;
        while(s.charAt(j)==' ')j--;
        String[] newS=s.substring(i,j+1).trim().replaceAll(" +"," ").split(" ");
        int m=0,n= newS.length-1;
        while(m<n){
            String temp=newS[m];
            newS[m]=newS[n];
            newS[n]=temp;
            m++;n--;
        }
        System.out.println(Arrays.toString(newS));
        String str="";
        for (int k = 0; k < newS.length; k++) {
            if(k< newS.length-1){
                str+=newS[k]+" ";
            }else{
                str+=newS[k];
            }
        }
        return str;
    }
}
