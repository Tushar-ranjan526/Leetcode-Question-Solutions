package Leetcode;

public class SubRepeatChar {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s){
        int len=0,i=0,j=0;
        String text="";
        while(j<s.length()){
           if(j<s.length()) {
               text += s.charAt(j);
               j++;
           }
            if(text.indexOf(s.charAt(j))==-1){
                len=Math.max(len,j-i+1);
            }else{
                i++;
                text=text.substring(1);
            }
        }

        return len;
    }
}
