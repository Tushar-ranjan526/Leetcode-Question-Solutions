package Leetcode;

public class MinOneOpMakeIntegersZero {
    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(6));
    }
    public static int minimumOneBitOperations(int n) {
        int[] f=new int[31];
        f[0]=1;
        for(int i=1;i<=30;i++){
            f[i]=2*f[i-1]+1;
        }
        int result=0;
        int sign=1;
        for(int i=30;i>=0;i--){
            int set=((1<<i)&n);
            if(set==0)continue;
            if(sign>0)
                result+=f[i];
            else
                result-=f[i];
            sign*=-1;
        }
        return result;
    }
}
