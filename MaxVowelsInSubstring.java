package Leetcode;

import java.util.Set;
import java.util.HashSet;
public class MaxVowelsInSubstring {
    public static void main(String[] args) {
        System.out.println(maxVowels("tryhard",4));
    }
    public static int maxVowels(String s, int k) {
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');
        vowels.add('o');vowels.add('u');

        int maxi=0,cnt=0,i=0,j=0;
        while(j<s.length()){
            if(vowels.contains(s.charAt(j))){
                cnt++;
            }
            int len=j-i+1;
            if(len>k){
                if(vowels.contains(s.charAt(i)))cnt--;
                i++;
                len=j-i+1;
            }
            if(len==k){
                maxi=Math.max(maxi,cnt);
            }

            j++;
        }
        return maxi;
    }
}
