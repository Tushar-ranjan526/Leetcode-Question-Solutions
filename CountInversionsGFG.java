import java.util.Arrays;
import java.util.List;

public class CountInversionsGFG {
    static int inversion=0;
    public static void main(String[] args) {
        int[] arr={2,4,1,3,5};
        System.out.println(inversionCount(arr));
    }
    static int inversionCount(int arr[]) {
        int[] inversion=new int[1];
        retTotalInversion(arr,inversion);
        return inversion[0];

    }
    static int[] retTotalInversion(int[] arr,int[] inv){
        if(arr.length==1){
            return arr;
        }

        int[] left=retTotalInversion(Arrays.copyOfRange(arr,0,arr.length/2),inv);
        int[] right=retTotalInversion(Arrays.copyOfRange(arr,arr.length/2,arr.length),inv);

        int[] ans=mergeArrays(left,right);
        inv[0]+=ans[ans.length-1];
        return Arrays.copyOfRange(ans,0,arr.length);
    }
    public static int[] mergeArrays(int[] left,int[] right){
        int[] full=new int[left.length+right.length+1];
        int i=0,j=0,inversion=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]>right[j]){
                inversion+=left.length-i;
                full[k]=right[j];
                j++;
            }else{
                full[k]=left[i];
                i++;
            }
            k++;
        }
        while(i<left.length){
            full[k]=left[i];
            i++;k++;
        }
        while(j<right.length){
            full[k]=right[j];
            j++;k++;
        }
        full[k]=inversion;
        return full;
    }
}
