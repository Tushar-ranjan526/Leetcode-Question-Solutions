package Leetcode;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] a) {
        int l=0,r=a.length-1,leftmax=0,rightmax=0,res=0;
        while(l<=r){
            if(a[l]<=a[r]){
                if(a[l]>=leftmax)leftmax=a[l];
                else res+=(leftmax-a[l]);
                l++;
            }
            else{
                if(a[r]>=rightmax)rightmax=a[r];
                else res+=(rightmax-a[r]);
                r--;
            }
        }
        return res;
    }
}
