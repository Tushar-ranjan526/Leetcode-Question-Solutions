package Leetcode;
import java.util.ArrayList;
public class MaxZeroes2D {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
        mat.add(new ArrayList<Integer>());
        mat.get(0).add(0,1);
        mat.get(0).add(0,1);
        mat.get(0).add(0,1);
        mat.add(new ArrayList<Integer>());
        mat.get(1).add(0,0);
        mat.get(1).add(0,0);
        mat.get(1).add(0,1);
        mat.add(new ArrayList<Integer>());
        mat.get(2).add(0,0);
        mat.get(2).add(0,0);
        mat.get(2).add(0,0);
        System.out.println(rowMaxOnes(mat,3,3));
    }
    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int maxZero=-1,index=-1;
        for(int i=0;i<n;i++){
            int s=0,e=n-1;
            while(s<=e){
                int mid=s+(e-s)/2;
                if(mat.get(i).get(mid)==1){
                    e=mid-1;
                }else s=mid+1;
            }
            int num=n-s;
            if(num>maxZero) {
                maxZero = num;
                index=i;
            }
        }
        return index;
    }
}
