package Leetcode;

public class RverseStringII {
    public static void main(String[] args){
        System.out.println(reverseStr("abcdefg",2));
    }
    public static String reverseStr(String s, int k) {
        int i=0,j=k-1;
        String str="";
        while(j<s.length()){
            str+=s.substring(j,j+1)+s.substring(i,i+1);
            i=i+2;
            j=j+2;
        }
        String lst=(s.length()%2!=0)?s.substring(i,i+1):"";
        return str+lst;
    }
}
