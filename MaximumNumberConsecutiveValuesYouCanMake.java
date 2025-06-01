import java.util.TreeMap;
import java.util.Map;
// Leetcode 1798.
public class MaximumNumberConsecutiveValuesYouCanMake {
    public static void main(String[] args) {
        MaximumNumberConsecutiveValuesYouCanMake mx=new MaximumNumberConsecutiveValuesYouCanMake();
        int[] coins={1,89,8,1,47,34,99,1,1,1,55,89,1,52,36,1,62,1,1,1,4,27,1,45,1,1,48,1,94,1,63};
        System.out.println(mx.getMaximumConsecutive(coins));
    }
    public int getMaximumConsecutive(int[] coins) {
        // to store the frequency of element
        Map<Integer,Integer> mpp=new TreeMap<>();
         for(int num:coins){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        int prev=0,range=0;
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            int curr=entry.getKey();
            if(prev+1>=curr){
                range=curr*entry.getValue()+prev;
                prev=range;
            }
        }
        return range+1;
    }
}
