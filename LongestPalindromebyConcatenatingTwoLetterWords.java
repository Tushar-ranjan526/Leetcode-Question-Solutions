import java.util.HashMap;
import java.util.Map;

public class LongestPalindromebyConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        LongestPalindromebyConcatenatingTwoLetterWords lw=new LongestPalindromebyConcatenatingTwoLetterWords();
        String[] words={"cc","ll","xx"};
        System.out.println(lw.longestPalindrome(words));
    }
    public int longestPalindrome(String[] words) {
        Map<String,Integer> mpp=new HashMap<>();
        int ans=0;
        for(int i=0;i<words.length;i++){
            String word=words[i];
            String rev=word.substring(1,word.length())+word.substring(0,1);
            if(mpp.containsKey(rev)){
                ans+=4;
                mpp.put(rev,mpp.get(rev)-1);
                if(mpp.get(rev)==0)mpp.remove(rev);
            }else{
                mpp.put(word,mpp.getOrDefault(word,0)+1);
            }
        }
        for(Map.Entry<String,Integer> entry:mpp.entrySet()){
            String word=entry.getKey();
            if(word.charAt(0)==word.charAt(1)){
                ans+=2;
                break;
            }
        }
        return ans;
    }
}
