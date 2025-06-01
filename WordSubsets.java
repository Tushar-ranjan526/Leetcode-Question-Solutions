import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public static void main(String[] args) {
        WordSubsets ws=new WordSubsets();
        String[] words1={"amazon","apple","facebook","google","leetcode"};
        String[] words2={"e","o"};
        System.out.println(ws.wordSubsets(words1,words2));

    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans=new ArrayList<>();
        Map<Character,Integer> tomatch=new HashMap<>();
        for(String str:words2){
            for(char ch:str.toCharArray()){
                tomatch.put(ch,tomatch.getOrDefault(ch,0)+1);
            }
        }
        for(String word:words1){
            Map<Character,Integer> mpp=new HashMap<>();
            for(char ch:word.toCharArray()){
                mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            }
            boolean match=true;
            for(Map.Entry<Character,Integer> entry:tomatch.entrySet()){
                char ch=entry.getKey();
                if(mpp.containsKey(ch)){
                    if(mpp.get(ch)<entry.getValue())
                        match=false;
                }else{
                    match=false;
                }
            }
            if(match){
                ans.add(word);
            }

        }
        return ans;
    }
}
