package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle t=new Triangle();
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        List<Integer> list4=new ArrayList<>();
        list1.add(-1);
        list2.add(2);list2.add(3);
        list3.add(1);list3.add(-1);list3.add(-3);
//        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        triangle.add(list1);triangle.add(list2);triangle.add(list3);
//        triangle.add(list4);
        System.out.println(t.minimumTotal(triangle));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return retMinTotal(triangle.size()-1,triangle);
    }
    public int retMinTotal(int i,List<List<Integer>> list){
        if(i<0){
            return 0;
        }
        if(i==0){
            return list.get(i).get(0);
        }
        int ans=Integer.MAX_VALUE;
        for(int s=0;s<list.get(i).size();s++){
            int val=list.get(i).get(s)+retMinTotal(i-1,list);
            ans=Math.min(val,ans);
        }
        return ans;
    }
}
