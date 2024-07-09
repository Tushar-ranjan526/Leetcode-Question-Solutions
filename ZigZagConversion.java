package Leetcode;

import java.util.Arrays;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
//        convert("PAYPALISHIRING",4);
    }
    public static String convert(String s, int numRows) {
        String[] str=new String[numRows];
        for (int i = 0; i < str.length; i++) {
            str[i]="";
        }
        int i=0;
        while(i<s.length()){
            for (int j = 0; j < numRows&&i<s.length(); j++) {
                str[j]+=s.charAt(i++);
            }
            for (int j =numRows-2; j >=1&&i<s.length() ; j--) {
                str[j]+=s.charAt(i++);
            }
        }
        String ans="";
        for (String word:str) {
            ans+=word;
        }
        return ans;
    }
}
