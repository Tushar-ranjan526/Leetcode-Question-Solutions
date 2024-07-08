package Leetcode;

public class SingleElement {
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));
    }
    public static int singleNonDuplicate(int[] nums){
        int s=0,e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            int focc=findFirstOcc(nums[m],nums,true);
            int locc=findFirstOcc(nums[m],nums,false);
            if(focc%2==1 && locc%2==0) e=m-1;
            else if(focc%2==0 && locc%2==1) s=m+1;
            else if(focc==locc) return nums[m];


        }
        return -1;
    }
    public static int findFirstOcc(int tar,int[] nums,boolean findfirst){
        int s=0,e=nums.length-1,ans=-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]<tar) s=m+1;
            else if(nums[m]>tar)e=m-1;
            else{
                ans=m;
                if(findfirst)
                e=m-1;
                else
                    s=m+1;
            }
        }
        return ans;
    }
}
