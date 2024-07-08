package Leetcode;

import java.util.ArrayList;

public class Numberpad {
    public static void main(String[] args) {
        System.out.println(pad("12",""));
    }
    public static ArrayList<String> pad(String up,String p){
    if(up.isEmpty()){
        ArrayList<String> list=new ArrayList<>();
        list.add(p);
        return list;
    }
        ArrayList<String> ans=new ArrayList<>();
        int digit=up.charAt(0)-'0';
        for (int i = (digit-1)*3; i <(digit*3) ; i++) {
            char ch=(char)('a'+i);
            ans.addAll(pad(up.substring(1),p+ch));
        }
    return ans;
    }
}