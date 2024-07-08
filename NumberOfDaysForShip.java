package Leetcode;

public class NumberOfDaysForShip {
    public static void main(String[] args) {
        int[] weights={1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights,10));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int sum=0;
        for(int ele:weights){
            sum+=ele;
        }
        int s=0,e=sum,ans=0;
        while(s<=e){
            int m=s+(e-s)/2;
            int time=retTime(m,weights);
            if(time<=days){
                ans=m;
                e=m-1;
            }
            else s=m+1;
        }
        return ans;
    }
    public static int retTime(double m,int[] nums){
        int req=0,totalTime=0;
        for(int ele:nums){
            if(req+ele<=m){
                req+=ele;
            }
            else{
                totalTime+=(int)Math.ceil(req/m);
                req=0;
                req+=ele;
            }
        }
        totalTime+=(int)Math.ceil(req/m);
        return totalTime;
    }
}
