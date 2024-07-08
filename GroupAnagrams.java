package Leetcode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> biglist=groupAnagrams(strs);
        System.out.println(biglist);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> biglist=groupString(strs);;
        return biglist;
    }

    private static  List<List<String>> groupString(String[] strs) {
        Map<String,List<String>> mpp=new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            String str=getSorted(strs[i]);
            if(mpp.containsKey(str)){
                mpp.get(str).add(strs[i]);
            }else{
                List<String> newList=new ArrayList<>();
                newList.add(strs[i]);
                mpp.put(str,newList);
            }
        }

            return new ArrayList<>(mpp.values());

    }

    private static String getSorted(String str) {
        char[] arr=str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

}
