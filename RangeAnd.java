package Leetcode;

public class RangeAnd {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        if(left==right)return left;
        //logic
        // left aur right dono ko right shift 1 karo jab tak wo dono equal nahi aa jaate.
        // and fir answer ko utni hi baar left shift kardo
        if(left==right)return left;
        int shift=0;
        while(left!=right){
            left=left>>1;
            right=right>>1;
            shift++;
        }
        return right<<shift;
    }
}
