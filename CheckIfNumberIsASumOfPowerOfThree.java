import java.util.HashSet;
import java.util.Set;

public class CheckIfNumberIsASumOfPowerOfThree {
    public static void main(String[] args) {
        CheckIfNumberIsASumOfPowerOfThree sc=new CheckIfNumberIsASumOfPowerOfThree();
        System.out.println(sc.checkPowersOfThree(12));
    }
    public boolean checkPowersOfThree(int n) {
        int i=0;
        Set<Integer> done=new HashSet<>();
        while(n>0){
            while((int)Math.pow(3,i)<=n){
                i++;
            }
            --i;
            if(done.contains(i)){
                return false;
            }else{
                n=n-(int)Math.pow(3,i);
                done.add(i);
            }
            i=0;
        }
        return n==0;
    }
}
