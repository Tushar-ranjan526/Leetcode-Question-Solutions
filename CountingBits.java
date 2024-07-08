package Leetcode;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
            int[] ans=countBits(5);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] countBits(int n) {
        int[] ans=new int[n+1];
        for (int i = 0; i <=n ; i++) {
            ans[i]=ans[i/2]+i%2;
        }
        return ans;
    }
//    0-0000
//    1-0001  1 odd hai aur uske aadhe waale index pe 0, 1bit hai to isme ek jyaada hai.
//    2-0010  2 even hai aur uske aadhe waale index pe 1 ,1bit hai.
//    3-0011  3 odd hai aur uske aadhe waale index hai 1,1bit hai.
//    4-0100
//    5-0101
//
//    to agar index even hai to seedha aadhe index pe jitne bits hai wahi answer hai
//            but agar index odd hai to uske aadhe waale index se 1 jyaada bit hai
}
