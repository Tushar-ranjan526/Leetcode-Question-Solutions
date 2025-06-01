import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring mws=new MinimumWindowSubstring();
        System.out.println(mws.minWindow("ADOBECODEBANC","ABC"));
    }
    public String minWindow(String s, String t) {
        int strind=-1,len=Integer.MAX_VALUE,i=0,j=0,cnt=0;
        Map<Character,Integer> mpp=new HashMap<>();
        for(char ch:t.toCharArray()){
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        while(j<s.length()){
            if(mpp.containsKey(s.charAt(j))){
                mpp.put(s.charAt(j),mpp.get(s.charAt(j))-1);
                if(mpp.get(s.charAt(j))==0)cnt++;
            }
            while(cnt==mpp.size()){
                if(len>j-i+1){
                    len=j-i+1;
                    strind=i;
                }
                if(mpp.containsKey(s.charAt(i))){
                    mpp.put(s.charAt(i),mpp.get(s.charAt(i))+1);
                    if(mpp.get(s.charAt(i))>0)cnt--;
                }
                i++;
            }
            j++;
        }
        return s.substring(strind,strind+len);
    }
}
