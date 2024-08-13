package Leetcode;

public class AverageGreaterThanThreshold {
    public static void main(String[] args) {
        int[] arr={11,13,17,23,29,31,7,5,2,3};
        System.out.println(numOfSubarrays(arr,3,5));
    }
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int i=0,j=0,sum=0,cnt=0;
        while(j<arr.length){
            sum+=arr[j];
            while(j-i+1>k){
                sum-=arr[i];
                i++;
            }
            if(j-i+1==k){
                int avg=sum/k;
                if(avg>=threshold)cnt++;
            }
            j++;
        }
        return cnt;
    }
}
