import java.util.Arrays;

public class CountTheNumberofFairPairs {
    public static void main(String[] args) {
        CountTheNumberofFairPairs cf=new CountTheNumberofFairPairs();
        int[] nums={0,1,7,4,4,5};
        System.out.println(cf.countFairPairs(nums,3,6));
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long ans=0,PairsSmallerThanLower=0,PairsSmallerThanUpper=0;

        for(int i=0;i<n;i++){
            PairsSmallerThanLower+=getPairsSmallerThanLower(i,nums,lower);
            PairsSmallerThanUpper+=getPairsSmallerThanUpper(i,nums,upper);
        }
        ans=PairsSmallerThanUpper-PairsSmallerThanLower;
        return ans;
    }

    public long getPairsSmallerThanLower(int i,int[] nums,int tar){
        int start=i+1,end=nums.length-1;
        long pairs=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[i]+nums[mid]<tar){
                pairs+=mid-start+1;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return pairs;
    }

    public long getPairsSmallerThanUpper(int i,int[] nums,int tar){
        int start=i+1,end=nums.length-1;
        long pairs=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[i]+nums[mid]<=tar){
                pairs+=mid-start+1;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return pairs;
    }

}
