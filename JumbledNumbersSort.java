package Leetcode;

import java.util.*;

public class JumbledNumbersSort {
    public static void main(String[] args) {
        int[] mapping={8,9,4,0,2,1,3,5,7,6},nums={991,338,38};
        int[] ans=sortJumbled(mapping,nums);
        System.out.println(Arrays.toString(ans));
    }
//    int[]
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> newArr=new ArrayList<>();
        for (int num=0;num<nums.length;num++){
            int ans=0;
            int pow=0;
            int i=nums[num];
            while(nums[num]!=0){
                int rem=nums[num]%10;
                ans=mapping[rem]*(int)Math.pow(10,pow)+ans;
                nums[num]/=10;
                pow++;
            }
            nums[num]=i;
            int[] newarr={num,ans};
            newArr.add(newarr);
        }
        Collections.sort(newArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int[] ans=new int[nums.length];
        for (int i = 0; i <newArr.size(); i++) {
            int[] ansarr=newArr.get(i);
            ans[i]=nums[ansarr[0]];
        }
        return ans;
    }
}
