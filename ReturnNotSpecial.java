package Leetcode;

public class ReturnNotSpecial {
    public static void main(String[] args) {
        System.out.println(nonSpecialCount(5,25));
    }
    public static  int nonSpecialCount(int l, int r) {
        int total=r-l+1;
        int special=0;
        int lim=(int)Math.sqrt(r);
        boolean[] primes=new boolean[lim+1];
        primes[1]=true;primes[0]=true;
        for (int i = 2; i*i <=lim ; i++) {
            if(!(primes[i])){
                for (int j = i*2; j <=lim ; j=j+i) {
                    primes[j]=true;
                }
            }
        }
        for (int i = 2; i <= lim; i++) {
            if(!primes[i]){
                int sq=i*i;
                if(l<=sq && sq<=r){
                    special++;
                }
            }
        }
        return total-special;
    }

}
