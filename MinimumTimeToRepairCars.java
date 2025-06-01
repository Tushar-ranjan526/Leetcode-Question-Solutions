public class MinimumTimeToRepairCars {
    public static void main(String[] args) {
        MinimumTimeToRepairCars mc=new MinimumTimeToRepairCars();
        int[] ranks={31,31,5,19,19,10,31,18,19,3,16,20,4,16,2,25,10,16,23,18,21,23,28,6,7,29,11,11,19,20,24,19,26,12,29,29,1,14,17,26,24,7,11,28,22,14,31,12,3,19,16,26,11};
        System.out.println(mc.repairCars(ranks,736185));
    }
    public long repairCars(int[] ranks, int cars) {
        long maxi=findMaxi(ranks);
        long end=maxi*cars*cars;
        long start=1,ans=0;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(canFinish(mid,ranks,cars)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean canFinish(long time,int[] ranks,int cars){
        int totalcars=cars;
        for(int rank:ranks){
            if(totalcars<=0)return true;
            int canclean=(int)Math.sqrt(time/rank);
            totalcars-=canclean;
        }
        return totalcars<=0;
    }
    public int findMaxi(int[] ranks){
        int maxi=0;
        for(int rank:ranks){
            maxi=Math.max(maxi,rank);
        }
        return maxi;
    }
}
