package Leetcode;

import java.util.Arrays;

public class OderlyQueue {
    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba",1));
    }
    public static String orderlyQueue(String s, int k) {
        char[] arr=s.toCharArray();
        if(k>1){
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        String ans=s;
        for (int i = 0; i <s.length() ; i++) {
            reOrder(arr);
            if(ans.compareTo(String.valueOf(arr))>0)ans=String.valueOf(arr);
        }
        return ans;
    }
    public static void reOrder(char[] arr){
        char temp=arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }
}
