import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOfSubstringContainingEveryVowelAndKConsonant {
    public static void main(String[] args) {
        CountOfSubstringContainingEveryVowelAndKConsonant csc=new CountOfSubstringContainingEveryVowelAndKConsonant();
        System.out.println(csc.countOfSubstrings("iqeaouqi",2));
    }
    public long countOfSubstrings(String word, int k) {
        int[] nextcons=new int[word.length()];
        int n=word.length();
        int nextone=n;
        Map<Character,Integer> mpp=new HashMap<>();
        mpp.put('a',1);mpp.put('e',1);mpp.put('i',1);mpp.put('o',1);
        mpp.put('u',1);
        for(int i=n-1;i>=0;i--){
            nextcons[i]=nextone;
            if(!mpp.containsKey(word.charAt(i))){
                nextone=i;
            }
        }
        int cons=0,vowels=0,i=0,j=0;
        long ans=0;
        while(j<word.length()){
            char ch=word.charAt(j);
            if(mpp.containsKey(ch)){
                mpp.put(ch,mpp.get(ch)-1);
                if(mpp.get(ch)==0){
                    vowels++;
                }
            }else{
                cons++;
            }
            if(cons>k){
                while(cons>k){
                    char curr=word.charAt(i);
                    if(mpp.containsKey(curr)){
                        mpp.put(curr,mpp.get(curr)+1);
                        if(mpp.get(curr)>0){
                            vowels--;
                        }
                    }else{
                        cons--;
                    }
                    i++;
                }
            }
            if(cons==k && vowels==5){
                    while(cons==k && vowels==5){
                        ans+=nextcons[j]-j;
                        char curr=word.charAt(i);
                        if(mpp.containsKey(curr)){
                            mpp.put(curr,mpp.get(curr)+1);
                            if(mpp.get(curr)>0){
                                vowels--;
                            }
                        }else{
                            cons--;
                        }
                        i++;
                    }
            }
            j++;
        }

        return ans;
    }
}
