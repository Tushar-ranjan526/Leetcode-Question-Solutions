package Leetcode;

public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums={0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int ans=0;
        for (int bits = 0; bits <32 ; bits++) {
            int zeroCount=0,oneCount=0,checker=1;
            checker=checker<<bits;
            for (int num:nums) {
                if((checker & num)==0)zeroCount++;
                else oneCount++;
            }
            if(oneCount%3!=0){
                int setter=1<<bits;
                ans=ans|setter;
            }
        }
        return ans;
    }
}
