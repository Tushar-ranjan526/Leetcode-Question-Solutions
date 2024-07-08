package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations_of_Integer {
    public static void main(String[] args) {
        List<List<Integer>> biglist = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int[] arr={1,2,3};
        permutationOfArr(arr,0,list,biglist);
    }
    public static void permutationOfArr(int[] arr,int i,List<Integer> list,List<List<Integer>> biglist){
        if(i==arr.length){
            if(list.size()>0){
                biglist.add(list);
                return;
            }
            return;
        }
        
    }
}
