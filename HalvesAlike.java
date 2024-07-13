package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class HalvesAlike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }
    public static boolean halvesAreAlike(String s) {
            String a=s.substring(0,s.length()/2);
            String b=s.substring(s.length()/2,s.length());
            int avow=calcVow(a);
            int bvow=calcVow(b);
            if(avow==bvow)return true;
            else return false;
    }

    private static int calcVow(String a) {
        int vow=0;
        for (int i = 0; i <a.length() ; i++) {
            if(a.charAt(i)=='a' || a.charAt(i)=='e' || a.charAt(i)=='i' || a.charAt(i)=='o' || a.charAt(i)=='u' || a.charAt(i)=='A' || a.charAt(i)=='E' || a.charAt(i)=='I' || a.charAt(i)=='O' || a.charAt(i)=='U' )
                vow++;
        }
        return vow;
    }
}
