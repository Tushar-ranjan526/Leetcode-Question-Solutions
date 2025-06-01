import java.util.*;
public class CountNumberOfBadPair {
    public static void main(String[] args) {
        CountNumberOfBadPair cp=new CountNumberOfBadPair();
        int[] nums={4,1,3,3};
        System.out.println(cp.countBadPairs(nums));
    }
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        Map<Integer, List<Integer>> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            int sub=nums[i]-i;
            if(mpp.containsKey(sub)){
                List<Integer> list=mpp.get(sub);
                list.add(i);
                mpp.put(sub,list);
                continue;
            }
            List<Integer> list=new ArrayList<>();
            list.add(i);
            mpp.put(sub,list);
        }
        n=n-1;
        int totalPairs=(n*(n+1))/2;
        int totalGoodPair=0;
        for(Map.Entry<Integer,List<Integer>> entry:mpp.entrySet()){
            List<Integer> list=entry.getValue();
            if(list.size()>1){
                int size=list.size()-1;
                totalGoodPair+=(size*(size+1))/2;
            }
        }
        return totalPairs-totalGoodPair;
    }
}
