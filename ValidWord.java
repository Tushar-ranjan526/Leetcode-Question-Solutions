package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidWord {
    public static void main(String[] args) {
        System.out.println(isValid("aya"));
//        isValid("234Adas");
    }
    public static boolean isValid(String word) {
        if(word.length()<3)return false;
        Set<Character> vowels=new HashSet<>();
        String vowelstring="aeiouAEIOU";
        for(int i=0;i<vowelstring.length();i++){
            vowels.add(vowelstring.charAt(i));
        }
        String consonantstring="BCDFGJKLMNPQSTVXZHRWYbcdfgjklmnpqstvxzhrwy";
        Set<Character> consonants=new HashSet<>();
        for(int i=0;i<consonantstring.length();i++){
            consonants.add(consonantstring.charAt(i));
        }
        Set<Character> numbers=new HashSet<>();
        numbers.add('1');
        numbers.add('2');
        numbers.add('3');
        numbers.add('4');
        numbers.add('5');
        numbers.add('6');
        numbers.add('7');
        numbers.add('8');
        numbers.add('9');
        numbers.add('0');
        int i=0,vowelen=0,consonantlen=0;
        while(i<word.length()){
            if(vowels.contains(word.charAt(i)) || consonants.contains(word.charAt(i)) || numbers.contains(word.charAt(i))){
                if(vowels.contains(word.charAt(i)))vowelen++;
                else if(consonants.contains(word.charAt(i)))consonantlen++;
            }else{
                return false;
            }
            i++;
        }
        return vowelen>=1 && consonantlen>=1;
    }
}
