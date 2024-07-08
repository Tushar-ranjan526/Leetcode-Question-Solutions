package Leetcode;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(1111111));
    }
        public static boolean isHappy(int n) {
            int slow=n;
            int fast=n;
            do{
                slow=getSquare(slow);
                fast=getSquare(getSquare(fast));
            }while(fast!=slow);

            if(slow==1){
                return true;
            }

            return false;

        }
        public static int getSquare(int num){
            int ans=0;
            while(num>0){
                int rem=num%10;
                ans+=rem*rem;
                num/=10;
            }
            return ans;
        }

}
