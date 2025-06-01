import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();
        String[] arr=inp.split(",");
        int[] nums=new int[arr.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(arr[i]);
        }
        sc.close();
        System.out.println(Arrays.toString(nums));
    }
}
