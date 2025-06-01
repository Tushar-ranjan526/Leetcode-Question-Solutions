import java.util.Arrays;
import java.util.Comparator;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        NextGreaterElementIII nx=new NextGreaterElementIII();
        System.out.println(nx.nextGreaterElement(2147483476));
    }
    public int nextGreaterElement(int n) {
        int temp=n,digits=(int)Math.log10(n)+1;
        int[] arr=new int[digits];
        int i=digits-1;
        while(temp>0){
            arr[i--]=temp%10;
            temp/=10;
        }
        int minind=arr.length-1;
        int nextgreatind=arr.length-1;
        while(minind>0){
            if(arr[minind]>arr[minind-1]){
                minind--;
                break;
            }
            minind--;
        }
        while(nextgreatind>=0){
            if(arr[nextgreatind]>arr[minind]){
                break;
            }
            nextgreatind--;
        }
        if(minind==-1 || nextgreatind==-1)return -1;
        int swapped=arr[nextgreatind];
        arr[nextgreatind]=arr[minind];
        arr[minind]=swapped;
        int l=minind+1,r=arr.length-1;
        while(l<r){
            int tempo=arr[l];
            arr[l++]=arr[r];
            arr[r--]=tempo;
        }
        int num=0,maxele=Integer.MAX_VALUE;
        for(int m=0;m<arr.length;m++){
            if(num>maxele/10 || num>(maxele/10+arr[m])){
                return -1;
            }
            num=num*10+arr[m];
        }
        return (n==num)?-1:num;

    }
}
