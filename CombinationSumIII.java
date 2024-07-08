package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        List<List<Integer>> list=combinationSum3(3,9);
        System.out.println(list);
    }
    public static List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> biglist= new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combinationSum(1,k,n,biglist,list);
        return biglist;
    }
    public static void combinationSum(int s,int end,int tar,List<List<Integer>> biglist,List<Integer> list){
        if(tar==0){
            if(list.size()==end) {
                biglist.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = s; i <=9 ; i++) {
            if(i>tar)break;
            list.add(i);
            combinationSum(i+1,end,tar-i,biglist,list);
            list.removeLast();
        }
    }
}
