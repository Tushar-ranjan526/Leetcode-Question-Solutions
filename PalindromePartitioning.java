package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> biglist= partition("aab");
        System.out.println(biglist);
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> biglist=new ArrayList<>();
        List<String> list=new ArrayList<>();
        findPartition(0,s,list,biglist);
        return biglist;
    }

    private static void findPartition(int i, String s, List<String> list, List<List<String>> biglist) {
        if(i==s.length()){
                biglist.add(new ArrayList<>(list));
                return;
        }
        for (int j = i; j < s.length(); j++) {
            String str=s.substring(i,j+1);
            if(checkPal(str)){
                list.add(str);
                findPartition(j+1,s,list,biglist);
                list.removeLast();
            }

        }
    }

    private static boolean checkPal(String str) {
        int i=0;
        while(i<str.length()/2){
            if(str.charAt(i)!=str.charAt(str.length()-i-1))return false;
            i++;
        }
        return true;
    }
}
