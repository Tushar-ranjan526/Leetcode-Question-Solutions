package Leetcode;

public class StringGreat {
    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
//        makeGood("leEetcAde");
    }
    public static String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            char ch=s.charAt(i);
            if( sb.length()>0 &&(sb.charAt(sb.length()-1)+32==ch || sb.charAt(sb.length()-1)-32==ch)){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
