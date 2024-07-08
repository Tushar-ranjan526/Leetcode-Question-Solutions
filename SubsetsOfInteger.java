package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetsOfInteger {
    public static void main(String[] args) {
        List<List<Integer>> biglist=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        biglist.add(list);
        int[] arr={1,2,3,4};
        subsetsMaker(0,biglist,list,arr);
        System.out.println(biglist);
    }
    public static void subsetsMaker(int i,List<List<Integer>> biglist,List<Integer> list,int[] arr){
        if(i==arr.length){
            if(list.size()>0){
                biglist.add(list);
                return;
            }
            return;
        }
        List<Integer> temp=new ArrayList<>(list);
        temp.add(arr[i]);
        subsetsMaker(i+1,biglist,temp,arr);
        subsetsMaker(i+1,biglist,list,arr);
        return;
    }
}
