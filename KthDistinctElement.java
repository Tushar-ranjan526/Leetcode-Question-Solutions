package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctElement {
    public static void main(String[] args) {
        String[] arr={"a","b","a"};
        int k=3;
        System.out.println(kthDistinct(arr,k));
    }
    public static String kthDistinct(String[] arr, int k) {
        Map<String,Integer> mpp=new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        for (int i = 0; i < arr.length; i++) {
            if(mpp.get(arr[i])==1){
                if(k==1)return arr[i];
                else{
                    mpp.put(arr[i],0);
                    k--;
                }
            }
        }
        return "";
    }
}
