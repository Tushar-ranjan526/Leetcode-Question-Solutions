import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueLengthThreePalindromicSubsequences {
    public static void main(String[] args) {
        UniqueLengthThreePalindromicSubsequences us=new UniqueLengthThreePalindromicSubsequences();
        System.out.println(us.countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"));
    }
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Set<Character> letters=new HashSet<>();
        for(char str:s.toCharArray()){
            letters.add(str);
        }
        int ans=0;
        Set<String> set=new HashSet<>();
        for(char letter:letters){
            int i=-1;
            int j=-1;
            for(int k=0;k<s.length();k++){
                if(s.charAt(k)==letter){
                    if(i==-1)i=k;
                    else{
                        j=k;
                    }
                }
            }

            for(int m=i+1;m<j;m++){
                String current=s.charAt(i)+"";
                set.add(current+s.charAt(m)+current);
            }
            ans=set.size();
        }
        return ans;
    }
}
