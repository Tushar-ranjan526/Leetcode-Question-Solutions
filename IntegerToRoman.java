package Leetcode;

import java.util.HashMap;
import java.util.Map;
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }
    public static String intToRoman(int num) {
        int[] number={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] sym={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res="";
        for (int i = 0; i <number.length ; i++) {
            if(num==0)break;
            int cnt=0;
            cnt=num/number[i];
            while (cnt!=0){
                res+=sym[i];
                cnt--;
            }
            num=num%number[i];
        }
        return res;
    }
}
