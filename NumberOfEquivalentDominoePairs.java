import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
public class NumberOfEquivalentDominoePairs {
    public static void main(String[] args) {
        NumberOfEquivalentDominoePairs np=new NumberOfEquivalentDominoePairs();
        int[][] dominoes={{2,1},{1,2},{1,2},{1,2},{2,1},{1,1},{1,2},{2,2}};
        System.out.println(np.numEquivDominoPairs(dominoes));
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans=0;
        Map<String,Integer> mpp=new HashMap<>();
        for(int i=0;i<dominoes.length;i++){
            boolean matches=false;
            if(i==0)mpp.put(Arrays.toString(dominoes[i]),1);
            else{
                int[] dup= Arrays.copyOfRange(dominoes[i],0,dominoes[0].length);
                swap(dup);
                if(!checkEqual(dup,dominoes[i])){
                    if(mpp.containsKey(Arrays.toString(dup))){
                        mpp.put(Arrays.toString(dup),mpp.get(Arrays.toString(dup))+1);
                        matches=true;
                    }
                }
                if(!matches){
                    if (mpp.containsKey(Arrays.toString(dominoes[i]))) {
                        mpp.put(Arrays.toString(dominoes[i]), mpp.get(Arrays.toString(dominoes[i])) + 1);
                    } else {
                        mpp.put(Arrays.toString(dominoes[i]), 1);
                    }
                }
            }
        }

        for(Map.Entry<String,Integer> entry:mpp.entrySet()){
            if(entry.getValue()>1){
                int n=entry.getValue();
                n=n*(n-1)/2;
                ans+=n;
            }
        }
        return ans;
    }
    public void swap(int[] arr){
        int temp=arr[0];
        arr[0]=arr[1];
        arr[1]=temp;
    }
    public boolean checkEqual(int[] arr1,int[] arr2){
        return Arrays.compare(arr1,arr2)==0;
    }
}
