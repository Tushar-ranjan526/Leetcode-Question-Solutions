package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Pnagram {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
    public static boolean checkIfPangram(String sentence) {
//        Map<Character,Integer> mpp=new HashMap<>();
//        for(int i=97;i<122;i++){
//            mpp.put((char)i,0);
//        }
//        for(int i=0;i<sentence.length();i++){
//            char ch=sentence.charAt(i);
//            mpp.put(ch,1);
//        }
//        int sum=0;
//        for(Map.Entry<Character,Integer> entry:mpp.entrySet()){
//            sum+=entry.getValue();
//        }
//        return (sum==26);
        if(sentence.contains("a") && sentence.contains("b") && sentence.contains("c") && sentence.contains("d") && sentence.contains("e") && sentence.contains("f") &&  sentence.contains("g") && sentence.contains("h") && sentence.contains("i") &&  sentence.contains("j") && sentence.contains("k") && sentence.contains("l") &&  sentence.contains("m") && sentence.contains("n") && sentence.contains("o") && sentence.contains("p") && sentence.contains("q") && sentence.contains("r") && sentence.contains("s") && sentence.contains("t") && sentence.contains("u") && sentence.contains("v") && sentence.contains("w") && sentence.contains("x") && sentence.contains("y") && sentence.contains("z"))
            return true;
        else
            return false;
    }
}
