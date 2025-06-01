public class MaximumValueOfAnOrderedTripletI {
    public static void main(String[] args) {
        MaximumValueOfAnOrderedTripletI ma=new MaximumValueOfAnOrderedTripletI();
        int[] nums={1000000,1,1000000};
        System.out.println(ma.maximumTripletValue(nums));
    }
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    long sub=nums[i]-nums[j];
                    ans=Math.max(ans,sub*nums[k]);
                }
            }
        }
        return ans;
    }
}
