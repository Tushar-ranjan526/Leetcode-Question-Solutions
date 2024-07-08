package Leetcode;

import java.util.*;
public class AppearTwice {
    public static void main(String[] args) {
        System.out.println(checkAppear("abcdd"));
    }

    private static char checkAppear(String s) {
        Map<String,Integer> mpp=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            if(!mpp.containsKey(s.substring(i,i+1))){
                mpp.put(s.substring(i,i+1),1);
            }else{
                return s.charAt(i);
            }
        }
        System.out.println(mpp);
        return 'n';
    }
}
