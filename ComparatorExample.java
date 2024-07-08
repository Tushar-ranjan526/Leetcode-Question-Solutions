package Leetcode;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        Comparator<String> com=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                return 1;
                else
                    return -1;
            }
        };
        Comparator<Integer> compa=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              Integer sum1=0,sum2=0;
                while(o1!=0){
                    Integer a=o1%10;
                    sum1=sum1*10+a;
                    o1=o1/10;
                }
                while(o2!=0){
                    Integer a=o1%10;
                    sum2=sum2*10+a;
                    o2=o2/10;
                }
                if(sum1>sum2){
                    return 1;
                }
                else
                    return -1;
            }
        };
        List<String> list=new ArrayList<>();
        list.add("Tushar");
        list.add("Harsh");
        list.add("SaqibMiya");
        list.add("Nishubaby");
        list.add("JaadiGandAniket");

        // Comparisons based on First Letter.
        Collections.sort(list);
        System.out.println(list);
        // Comparison based on length of Strings.
        // khudka logic.
        Collections.sort(list,com);
        System.out.println(list);

        List<Integer> nums=new ArrayList<>();
        nums.add(23);
        nums.add(42);
        nums.add(111);
        nums.add(29);
        Collections.sort(nums);
        System.out.println(nums);

        Collections.sort(nums,compa);
        System.out.println(nums);
    }
}
