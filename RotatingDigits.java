package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RotatingDigits {
    public static void main(String[] args) {
        RotatingDigits rd=new RotatingDigits();
        System.out.println(rd.rotatedDigits(10));
    }
    public int rotatedDigits(int n) {
    int count=0;
    int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<10){
                if(i==1 || i==0 || i==8){
                    dp[i]=1;
                }else if(i==2 || i==5 || i==6 || i==9){
                    dp[i]=2;
                    count++;
                }
            }else{
                int a=dp[i/10],b=dp[i%10];
                if(a==1 && b==1){
                    dp[i]=1;
                }else if(a>1 || b>1){
                    dp[i]=2;
                    count++;
                }
            }
        }
        return count;
    }
//    public int rotateDigits(int i,Map<Integer,Integer> mpp){
//        if(i<2)return 0;
//        int temp=i;
//        int pow=0,newn=0;
//        while(i!=0){
//            int n=i%10;
//            if(!mpp.containsKey(n))return 0+rotateDigits(temp-1,mpp);
//            else{
//                n=mpp.get(n);
//            }
//            newn=newn+n*(int)Math.pow(10,pow);
//            pow++;
//            i/=10;
//        }
//        if(newn==temp)return 0+rotateDigits(temp-1,mpp);
//        else return 1+rotateDigits(temp-1,mpp);
//    }
    
}
