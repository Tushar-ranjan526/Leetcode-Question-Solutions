package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> mpp=new HashMap<>();
        int i=0,j=0,maxLen=0,maxCount=0;
        while(j<s.length()){
            mpp.put(s.charAt(j),mpp.getOrDefault(s.charAt(j),0)+1);
            maxCount=Math.max(maxCount,mpp.get(s.charAt(j)));
            if(Math.abs((j-i+1)-maxCount)<= k){
                maxLen=Math.max(maxLen,j-i+1);
            }
            if(Math.abs((j-i+1)-maxCount)>k){
                mpp.put(s.charAt(i),mpp.get(s.charAt(i))-1);
                if(mpp.get(s.charAt(i))==0)mpp.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return maxLen;
    }
}
