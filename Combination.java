package Leetcode;
import java.util.*;
public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> biglist=combine(4,2);
        System.out.println(biglist);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> biglist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findCombinations(1,biglist, list, n, k);
        return biglist;
    }

    private static void findCombinations(int s,List<List<Integer>> biglist, List<Integer> list, int n, int k) {
        if(list.size()==k){
                biglist.add(new ArrayList<>(list));
                return;
        }
        for(int i=s;i<=n;i++){
            list.add(i);
            findCombinations(s+1,biglist,list,n,k);
            list.removeLast();
        }
        return;
    }
}
