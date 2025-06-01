public class ZeroTransformationArrayII {
    public static void main(String[] args) {
        ZeroTransformationArrayII za=new ZeroTransformationArrayII();
        int[] nums={7,6,8};
        int[][] queries={{0,0,2},{0,1,5},{2,2,5},{0,2,4}};
        System.out.println(za.minZeroArray(nums,queries));
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int s=0,e=queries.length-1,ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(performQueries(nums,queries,mid)){
                ans=mid+1;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean performQueries(int[] nums,int[][] queries,int upto){
        int n=nums.length;
        int[] arr=new int[n+1];
        int[] dup=new int[n];
        for(int i=0;i<n;i++){
            dup[i]=nums[i];
        }
// difference array:
//      queries[start,end,val] aise ho to:
//                              ek naya array lo same original size ka with all elements 0
//                              then queries ke hisaab se arr[start] pe plus kardo agar plus karna ho , minus agar minus
//                              aur arr[end+1] index pe ulta--> minus karna ho to plus kardo, agar plus karna ho to minus
//                              fir last mei harr element ko add kardo ek cummulative sum ki tarah
//                                  1st remains same baaki sum hote rahenge.
        for(int i=0;i<=upto;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int val=queries[i][2];
            arr[start]=arr[start]-val;
            arr[end+1]=arr[end+1]+val;
        }
        for(int i=0;i<n+1;i++){
            if(i>0)arr[i]=arr[i-1]+arr[i];
            if(i>=0 && i<n){
                dup[i]=dup[i]+arr[i];
                if(dup[i]<0)dup[i]=0;
                if(dup[i]!=0)return false;
            }
        }
        return true;
    }
}
