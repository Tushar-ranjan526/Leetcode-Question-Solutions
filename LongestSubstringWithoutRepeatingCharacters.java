import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lc=new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lc.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mpp=new HashMap<>();
        int i=0,j=0,n=s.length(),maxlen=0;
        while(j<n){
            if(mpp.containsKey(s.charAt(j))){
                i=Math.max(i,mpp.get(s.charAt(j))+1);
                mpp.put(s.charAt(j),j);
            }else{
                mpp.put(s.charAt(j),j);
            }
            System.out.println(mpp);
            maxlen=Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}
