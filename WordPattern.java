package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog dog dog dog"));
//        wordPattern("abba","cat dog dog cat");
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] sarr=s.split(" ");
        if(pattern.length()!=sarr.length)return false;
        Map<Character,String> mpp=new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(mpp.containsKey(pattern.charAt(i))){
                if(!mpp.get(pattern.charAt(i)).equals(sarr[i]))return false;
            }else{
                if(mpp.containsValue(sarr[i]))
                    return false;
                mpp.put(pattern.charAt(i),sarr[i]);
            }
        }
        return true;
    }
}
