package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        int i=0,j=0,cnt=0,strind=-1,minlen=Integer.MAX_VALUE;
        Map<Character,Integer> mpp=new HashMap<>();
        for (int k = 0; k <t.length() ; k++) {
            mpp.put(t.charAt(k),mpp.getOrDefault(t.charAt(k),0)+1);
        }

        while(j<s.length()){
            if(mpp.containsKey(s.charAt(j))){
                mpp.put(s.charAt(j),mpp.get(s.charAt(j))-1);
                if(mpp.get(s.charAt(j))==0)cnt++;
            }
            while(cnt==mpp.size()) {
                int len = j - i + 1;
                if (len < minlen) {
                    minlen = len;
                    strind = i;
                }
                if (mpp.containsKey(s.charAt(i))) {
                    mpp.put(s.charAt(i), mpp.get(s.charAt(i)) + 1);
                    if (mpp.get(s.charAt(i)) > 0)
                        cnt--;
                }
                i++;
            }
            j++;
        }
        return s.substring(strind,strind+minlen);
    }
}
