package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        List<String> list=letterCombinations("2");
        System.out.println(list);
    }
    public static List<String> letterCombinations(String digits) {
            List<String> list=new ArrayList<>();
        HashMap<String,String> phone=new HashMap<>();
        phone.put("2","abc");
        phone.put("3","def");
        phone.put("4","ghi");
        phone.put("5","jkl");
        phone.put("6","mno");
        phone.put("7","pqrs");
        phone.put("8","tuv");
        phone.put("9","wxyz");
            findAllCombination(digits,"",phone,list);
            return list;
    }

    private static void findAllCombination(String digits, String p, HashMap<String, String> mpp,List<String> list) {
        if(digits.isEmpty()){
            list.add(p);
            return;
        }
        String s=digits.substring(0,1);
        String alph=mpp.get(s);
        for (int i = 0; i <alph.length() ; i++) {
            String pro=p+alph.substring(i,i+1);
            findAllCombination(digits.substring(1),pro,mpp,list);
        }
    }
}
