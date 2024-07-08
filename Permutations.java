package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        givePermutations("abc");
    }
    public static void givePermutations(String s){
        List<String> list=new ArrayList<>();
        permutation(s,"",list);
        System.out.println(list);
    }
    public static void permutation(String op,String ip,List<String> list){
        if(op.length()==0){
            list.add(ip);
            return;
        }
        for (int i = 0; i <op.length() ; i++) {
            String newop= op.substring(0,i)+op.substring(i+1);
            String newip=op.substring(i,i+1);
            permutation(newop,newip+ip,list);
        }
    }
}
