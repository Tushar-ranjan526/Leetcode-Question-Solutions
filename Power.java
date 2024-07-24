package Leetcode;

public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2.0000,-2));
    }

    public static double myPow(double x, int n) {
       return solvePow(x,n);
    }
    public static double solvePow(double x, long n){
        if(n==0)return 1;
        if(n < 0) return solvePow(1/x,-n);
        if(n % 2 == 0) return solvePow(x*x,n/2);
        if(n % 2 !=0) return x*solvePow(x*x,(n-1)/2);
        return 1;
    }
}