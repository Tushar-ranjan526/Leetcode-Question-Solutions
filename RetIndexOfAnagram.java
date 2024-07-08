package Leetcode;
import java.util.*;
public class RetIndexOfAnagram {
    public static void main(String[] args) {
        List<Integer> list=findAnagrams("cbaebabacd","abc");
        System.out.println(list);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        Map<Character,Integer> mpp=new HashMap<>();
        for(int i=0;i<p.length();i++){
            if(mpp.containsKey(p.charAt(i)))mpp.put(p.charAt(i),mpp.get(p.charAt(i))+1);
            else mpp.put(p.charAt(i),1);
        }
        System.out.println(mpp);
        int i=0,j=0,patLength=p.length(),beforeVal=0;
        while(j<s.length()){
            if(mpp.containsKey(s.charAt(j))){
                mpp.put(s.charAt(j),mpp.get(s.charAt(j))-1);
            }
            System.out.println(mpp);
            if(j-i+1==patLength){
                if(allZero(mpp)){
                    list.add(i);
                    mpp.put(s.charAt(i),1);
                }

                i++;
            }
            j++;
        }
        return list;
    }
    public static boolean allZero(Map<Character,Integer> mpp){
        boolean isTrue=false;
        for(Map.Entry<Character,Integer> entry:mpp.entrySet()){
            if(entry.getValue()==0)isTrue=true;
            else return false;
        }
        return isTrue;
    }
}
