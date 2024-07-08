package Leetcode;

public class PassThePillow {
    public static void main(String[] args) {
        System.out.println(passThePillow(18,38));
    }
    public static int passThePillow(int n, int time) {
        if(n>time){
            int rem=time%n;
            return 1+rem;
        }
        else{
            int rem=time%(n-1);
            if((time/(n-1))%2!=0)
                return n-rem;
            else
                return 1+rem;
        }
    }
}
