package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        List<List<Integer>> biglist=combinationSum(candidates,target);
        System.out.println(biglist);
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> biglist=new ArrayList<>();
        totalSum(0,candidates,target,biglist,list);
        return biglist;
    }

    private static void totalSum(int i, int[] candidates, int target,List<List<Integer>> biglist,List<Integer> list) {
        if(i==candidates.length){
            if(target==0){biglist.add(new ArrayList<>(list));}
            return;
        }
        if(candidates[i]<=target) {
            list.add(candidates[i]);
            totalSum(i, candidates, target - candidates[i],biglist, list);
            list.removeLast();
        }
        totalSum(i+1,candidates,target,biglist,list);
    }
}
