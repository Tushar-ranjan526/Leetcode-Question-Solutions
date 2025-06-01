import java.util.Arrays;
public class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {
        CountWaysToBuildGoodStrings cs=new CountWaysToBuildGoodStrings();
        System.out.println(cs.countGoodStrings(3,3,1,1));
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
//        dp[0] = 1;
        int mod = (int) Math.pow(10, 9) + 7;
        return makeGoodStrings(0, low, high, zero, one, dp, mod);
    }

    public int makeGoodStrings(int size, int low, int high, int zero, int one, int[] dp, int mod) {
        if (size > high) {
            return 0;
        }
        if (dp[size] != -1)
            return dp[size];
        int cnt = (size >= low) ? 1 : 0;
        cnt = (cnt + makeGoodStrings(size + zero, low, high, zero, one, dp, mod)) % mod;
        cnt = (cnt + makeGoodStrings(size + one, low, high, zero, one, dp, mod)) % mod;
        dp[size] = cnt;
        return cnt;
    }
}
