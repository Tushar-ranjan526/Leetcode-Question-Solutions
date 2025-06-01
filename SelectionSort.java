import java.util.Arrays;
import java.util.Date;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums={13,46,24,52,20,9};
//        selectionSort(nums);
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void selectionSort(int[] nums){
        // mai ith element ko select karke sabse chhota maan lunga aur uske baad check karunga ki isse chhota koi hai to swap kardo.
        for(int i=0;i<nums.length;i++){
            int mini=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(mini>nums[j]){
                    mini=nums[j];
                   swap(i,j,nums);
                }
            }
        }
    }

    public static void insertionSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            // i ke ek aage se chaalu karo aur utne ko pura sort kardo then naye nnumber ko insert karo next round mei aur usko bhi sort kardo.
            for(int j=i+1;j>=1;j--){
                if(nums[j]<nums[j-1]){
                    swap(j,j-1,nums);
                }
            }
        }
    }

    public static void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
