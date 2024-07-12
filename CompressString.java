package Leetcode;

public class CompressString {
    public static void main(String[] args) {
        char[] chars={'a','b','c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if(chars.length==1)return 1;
        int i=0,j=1;
        int cnt=1;
        String str="";
        while(j<chars.length){
            if(chars[i]==chars[j])cnt++;
            else{
                str+=chars[i]+"";
                if(cnt!=1)
                str+=cnt;
                cnt=1;
                i=j;
            }
            if(j<chars.length)
                j++;
        }

            str+=chars[i];
        if(cnt!=1){
            str+=cnt;
        }
        for (int k = 0; k < str.length(); k++) {
            chars[k]=str.charAt(k);
        }
        return str.length();
    }
}
