package Leetcode;

public class BloomingDays {
    public static void main(String[] args) {
        int[] bloomDay={1000000,1000000};
        System.out.println(minDays(bloomDay,1,1));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int totalflower=m*k;
        if(totalflower>bloomDay.length)return -1;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int s=0,e=max,ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(bloomingDay(bloomDay,mid,m,k)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public static boolean bloomingDay(int[] bloomDay,int day,int m,int k){
        int cnt=0,bloom=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                bloom+=cnt/k;
                cnt=0;
            }
        }
        bloom+=cnt/k;
        if(bloom>=m)return true;
        else return false;
    }
}
