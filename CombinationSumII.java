package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr={2,5,2,1,2};
        List<List<Integer>> biglist=retCombinationSumII(arr,5);
        System.out.println(biglist);
    }

    private static List<List<Integer>> retCombinationSumII(int[] arr, int tar) {
        Arrays.sort(arr);
        List<List<Integer>> biglist=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combinationSum(0,tar,biglist,list,arr);
        return biglist;
    }

    private static void combinationSum(int s, int tar, List<List<Integer>> biglist, List<Integer> list,int[] arr) {
            if(tar==0){
                biglist.add(new ArrayList<>(list));
                return;
            }
        for(int i=s;i<arr.length;i++){
            if(i>s && arr[i]==arr[i-1]) continue;
            if(arr[i]>tar)break;
                list.add(arr[i]);
                combinationSum(i + 1, tar - arr[i], biglist, list, arr);
                list.removeLast();

        }

    }
}
