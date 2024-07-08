package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitintoBasket {
    public static void main(String[] args) {
        int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(fruitsInBask(fruits));
    }
    public static int fruitsInBask(int[] fruits){
        Map<Integer,Integer> mpp=new HashMap<>();
        int r=0,l=0,k=2,maxlen=0;
        while(r<fruits.length){
            mpp.put(fruits[r],mpp.getOrDefault(fruits[r],0)+1);
            if(mpp.size()>k){
                while(mpp.size()>k) {
                    int val = mpp.get(fruits[l]);
                    val--;
                    mpp.put(fruits[l], val);
                    if (mpp.get(fruits[l]) == 0)
                        mpp.remove(fruits[l]);
                    l++;
                }
            }
            if(mpp.size()<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
