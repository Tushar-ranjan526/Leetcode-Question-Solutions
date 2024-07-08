package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s1="MCMXCIV";
        System.out.println(retInt(s1));
    }
    private static int retInt(String s1) {
        Map<Character,Integer> mpp=new HashMap<>();
        mpp.put('I',1);mpp.put('V',5);mpp.put('X',10);mpp.put('L',50);
        mpp.put('C',100);mpp.put('D',500);mpp.put('M',1000);
        int sum=0,i=0;

        while(i<s1.length()){
            if(i<s1.length()-1 && mpp.get(s1.charAt(i))<mpp.get(s1.charAt(i+1))){
                sum+=mpp.get(s1.charAt(i+1))-mpp.get(s1.charAt(i));
                i+=2;
            }else{
                sum+=+mpp.get(s1.charAt(i));
                i+=1;
            }
        }
        return sum;
    }

}
