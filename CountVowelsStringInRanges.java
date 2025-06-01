import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelsStringInRanges {
    public static void main(String[] args) {
        CountVowelsStringInRanges cs=new CountVowelsStringInRanges();
        String[] words={"a","e","i"};
        int[][] queries={{0,2},{0,1},{2,2}};
        int[] ans=cs.vowelStrings(words,queries);
        System.out.println(Arrays.toString(ans));
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int[] ans=new int[queries.length];
        int[] totalVowels=new int[n];
        int total=0;
        for(int i=0;i<n;i++){
            String word=words[i];
            char first=word.charAt(0),last=word.charAt(word.length()-1);;
            if((first=='a'||first=='e'||first=='i'||first=='o'||first=='u')&&(last=='a'||last=='e'||last=='i'||last=='o'||last=='u')){
                total++;
            }
            totalVowels[i]=total;
        }
        Integer a=10;
        Integer b=10;
        if(a.equals(b)){
            System.out.println("hey");
        }
        for(int i=0;i< queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(start==0){
                ans[i]=totalVowels[end];
            }else{
                int answer=totalVowels[end]-totalVowels[start-1];
                ans[i]=answer;
            }
        }
        return ans;
    }
}
