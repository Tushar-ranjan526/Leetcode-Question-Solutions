import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence ls=new LengthOfLongestFibonacciSubsequence();
        int[] arr={1,2,3,4,5,6,7,8};
        System.out.println(ls.lenLongestFibSubseq(arr));
    }
    public int lenLongestFibSubseq(int[] arr) {
        int len=1;
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            mpp.put(arr[i],i);
        }
        for(int i=0;i<=arr.length-3;i++){
            for(int j=i+1;j<arr.length;j++){
                int first=arr[i];
                int sec=arr[j];
                int maxlen=2;
                while(mpp.containsKey(first+sec)){
                    maxlen++;
                    len=Math.max(maxlen,len);
                    int temp=sec;
                    sec=sec+first;
                    first=temp;
                }
            }
        }
        return len;
    }
}
