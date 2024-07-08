package Leetcode;

import java.util.Arrays;

public class NumberDecoding {
    public static void main(String[] args) {
        System.out.println(numDecoding("27"));
    }
    public static int numDecoding(String s){
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        if(isValid(0,s,true))dp[1]=1;
        else dp[1]=0;
        for (int i = 2; i <=s.length(); i++) {
            int valid=0;
            if(isValid(i-1,s,true)){
                valid+=dp[i-1];
            }
            if(isValid(i-1,s,false)){
                valid+=dp[i-2];
            }
            dp[i]=valid;
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
  public static boolean isValid(int i,String s,boolean forsingle){

        if(forsingle){
            if(s.charAt(i)!='0')return true;
            else return false;
        }else{
            int n=(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
            System.out.println(n);
            if((s.charAt(i)!='0'||s.charAt(i)=='0') && s.charAt(i-1)!='0' && n<27)return true;
            else return false;
        }
  }
}
