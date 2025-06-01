public class MinimumEqualSumOfTwoArraysReplacingZero {
    public static void main(String[] args) {
        MinimumEqualSumOfTwoArraysReplacingZero mz=new MinimumEqualSumOfTwoArraysReplacingZero();
        int[] nums1={0,16,28,12,10,15,25,24,6,0,0};
        int[] nums2={20,15,19,5,6,29,25,8,12};
        System.out.println(mz.minSum(nums1,nums2));
    }
    public long minSum(int[] nums1, int[] nums2) {
        int sum1=0,sum2=0,zeroes1=0,zeroes2=0;
        long ans=Integer.MIN_VALUE;
        for(int num:nums1){
            if(num==0)zeroes1++;
            sum1+=num;
        }
        for(int num:nums2){
            if(num==0)zeroes2++;
            sum2+=num;
        }
        while(ans!=sum2 && ans!=sum1){
            sum1+=zeroes1;
            sum2+=zeroes2;
            if(sum1==sum2)return sum1;
            if(sum1<sum2){
                if(zeroes1>0){
                    long diff=sum2-sum1;
                    ans=sum1+diff;
                }else{
                    return -1;
                }
            }
            else{
                if(zeroes2>0){
                    long diff=sum1-sum2;
                    ans=sum2+diff;
                }else{
                    return -1;
                }
            }
        }
        return ans;
    }
}
