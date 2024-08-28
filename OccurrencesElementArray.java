package Leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;


public class OccurrencesElementArray {
    public static void main(String[] args) {
        int[] nums={1,3,1,7};
        int[] queries={1,3,2,4};
        OccurrencesElementArray oa=new OccurrencesElementArray();
        int[] ans=oa.occurrencesOfElement(nums,queries,1);
        System.out.println(Arrays.toString(ans));
    }
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer,Integer> mpp=new HashMap<>();
        int occ=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                mpp.put(occ,i);
                occ++;
            }
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            if(mpp.size()>=queries[i])ans[i]=mpp.get(queries[i]);
            else ans[i]=-1;
        }
        return ans;
    }
}
