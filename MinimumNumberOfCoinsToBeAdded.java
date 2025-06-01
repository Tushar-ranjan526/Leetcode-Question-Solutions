import java.util.Arrays;

public class MinimumNumberOfCoinsToBeAdded {
    public static void main(String[] args) {
        MinimumNumberOfCoinsToBeAdded ma=new MinimumNumberOfCoinsToBeAdded();
        int[] coins={1,2,31,33};
        System.out.println(ma.minimumAddedCoins(coins,2147483647));
    }
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        long range=0;
        int add=0,i=0;
        while(i<coins.length){
            if(range>=target)break;
            if(range+1>=coins[i]){
                range+=coins[i++];
            }else{
                add++;
                range+=range+1;
            }
        }
        while(range<target){
            range+=range+1;
            add++;
        }
        return add;
    }
}
