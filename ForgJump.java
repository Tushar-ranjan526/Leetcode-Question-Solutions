package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ForgJump {
    public static void main(String[] args) {
        int[] nums={0,1,2,3,4,8,9,11};
        System.out.println(canCross(nums));
    }
    public static boolean canCross(int[] stones) {
        Boolean[][] dp=new Boolean[stones.length][stones.length];
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i< stones.length;i++)mpp.put(stones[i],i);
        return canJump(0,0,stones,mpp,dp);
    }
    public static boolean canJump(int i,int pj,int[] stones,Map<Integer,Integer> mpp,Boolean[][] dp){
        if(i==stones.length-1)return true;
        if(i>=stones.length)return false;
        if(dp[i][pj]!=null) return dp[i][pj];
        boolean jmp=false;
        for(int jump=-1;jump<=1;jump++){
            if(mpp.containsKey(stones[i]+pj+jump) && pj+jump>0){
                jmp= jmp || canJump(mpp.get(stones[i]+pj+jump),pj+jump,stones,mpp,dp);
            }
        }
        return dp[i][pj]=jmp;
    }
}
