package Leetcode;
import java.util.Map;
import java.util.HashMap;

public class LongestSubstringNoRepeat {
    public static void main(String[] args) {
        System.out.println(checkRepeatation("bbbbb"));
    }
    public static int checkRepeatation(String s){
        Map<Character,Integer> mpp=new HashMap<>();
        int i=0,j=0,maxlen=0;
        while(j<s.length()){
            if(mpp.containsKey(s.charAt(j))){
                i=Math.max(mpp.get(s.charAt(j))+1,i);
            }
            mpp.put(s.charAt(j),j);
            maxlen=Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}
