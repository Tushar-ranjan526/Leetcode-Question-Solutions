package Leetcode;
import java.util.List;
import java.util.ArrayList;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
   public static int countAndSay(int n){
        return Integer.parseInt(func(n));
   }
   public static String func(int n){
        String res="";
        if(n==1){
            return "1";
        }
        String say=func(n-1);
       for (int i = 0; i <say.length() ; i++) {
           int count=1;
           char ele=say.charAt(i);
           while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1)){
               count++;
               i++;
           }
           res+=Integer.toString(count)+Character.toString(say.charAt(i));
       }
       return res;
   }
}
