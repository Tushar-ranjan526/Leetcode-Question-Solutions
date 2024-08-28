package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class KeysKeyboard {
    public static void main(String[] args) {
        KeysKeyboard kb=new KeysKeyboard();
        System.out.println(kb.minSteps(6));
    }
    public int minSteps(int n) {
        if(n==1)return 0;
        if(isPrime(n))return n;
        else{
            int temp=n;
            List<Integer> list=new ArrayList<>();
            while(n%2==0){
                list.add(2);
                n/=2;
            }
            for(int i=3;i<=n;i+=2){
                while(n%i==0){list.add(i);
                n/=i;
                }
            }

            int sum=0;
            for(Integer num:list){
                sum+=num;
            }
            return sum;
        }
    }
    public boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
