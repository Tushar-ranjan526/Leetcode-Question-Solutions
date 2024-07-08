package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CheckPerm {
    public static void main(String[] args) {
            List<String> list1=checkPer("eidboaooo","ab");
            List<String> list2=checkPer("ab","ab");
        System.out.println(checkForString(list1,list2));

    }
    public static boolean checkForString(List<String> list1, List<String> list2){
        for(String it:list2){
            for(String it1:list1){
                if(it1.equals(it))
                    return true;
            }
        }
        return false;
    }
    public static List<String> checkPer(String s,String s2){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < s.length()-(s2.length()-1); i++) {
            list.addAll(givePer(s.substring(i,i+s2.length()),""));
        }
        return list;
    }
    public static List<String> givePer(String op,String ip){
        if(op.length()==0){
            List<String> allper=new ArrayList<>();
            allper.add(ip);
            return allper;
        }
        List<String> allper=new ArrayList<>();
        for (int i = 0; i < op.length(); i++) {
            String newip=op.substring(i,i+1);
            String newop=op.substring(0,i)+op.substring(i+1);
            allper.addAll(givePer(newop,newip+ip));
        }
    return allper;
    }
}
