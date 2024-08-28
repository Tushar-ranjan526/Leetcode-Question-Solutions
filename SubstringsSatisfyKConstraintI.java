package Leetcode;

public class SubstringsSatisfyKConstraintI {
    public static void main(String[] args) {
        SubstringsSatisfyKConstraintI sc=new SubstringsSatisfyKConstraintI();
        System.out.println(sc.countKConstraintSubstrings("000011",1));
    }
    public int countKConstraintSubstrings(String s, int k) {
        int count=0;
        int i=0,j=0,cnt1=0,cnt0=0;
        while(j<s.length()){
            if(s.charAt(j)=='1')cnt1++;
            else if(s.charAt(j)=='0')cnt0++;
            while(cnt1>k && cnt0>k){
                if(s.charAt(i)=='1')cnt1--;
                else if(s.charAt(i)=='0')cnt0--;
                i++;
            }
            if(cnt1<=k || cnt0<=k){
                count+=j-i+1;
            }
            j++;
        }
        return count;
    }
}
