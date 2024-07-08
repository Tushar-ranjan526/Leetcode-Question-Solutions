package Leetcode;
import java.util.ArrayList;
public class AllocateBooks {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(12);
        arr.add(34);
        arr.add(67);
        arr.add(90);
//        arr.add(24);
        System.out.println(findPages(arr,arr.size(),2));
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        //edge case when students are more
        if(arr.size()<m)return -1;

        // initializing start and end of b.s.
        // to allocate every book minimum no. of pages should be the highest pages we have.if we decide to allocate single book to each student
        int maxi=0,sum=0;
        for(Integer ele:arr){
            maxi=Math.max(ele,maxi);
            sum+=ele;
        }
        int ans=Integer.MAX_VALUE,s=maxi,e=sum;

        // binary search
        while(s<=e){
            int mid=s+(e-s)/2;

            // mid is passed to a function which calculates if we can allocate books to every students if we take max pages as mid.
            boolean allocation=allocateBooks(arr,m,mid);

            // if it returns true then it is a possible answer but still try to find less number of books.
            // so move to left.
            if(allocation){
                ans=Math.min(ans,mid);
                e=mid-1;
            // but if it returns false then number of pages should be more
            // so we move to right
            }else s=mid+1;
        }
        return ans;
    }
    public static boolean allocateBooks(ArrayList<Integer> arr,int m,int mid){
        // we can always allocate the first book to first student
        int total=arr.get(0);
        int stu=m;

        // iterate over array and check foe many students can we allocate the books if we take max pages as mid
        for(int i=1;i<arr.size();i++){

            // if i take current book and next book and add number of pages then can i allocate it to same person.
            if(total+arr.get(i)<=mid){
                total+=arr.get(i);
            }else{
                // if i cannot allocate next book then allocate the books we have uptil now and discard that student
                m--;
                // and recheck for next student
                total=arr.get(i);
            }
        }
        // for the last student because for last student else condtion will never come
        m--;

        // return true only when i can allocate all book to 2 or 3 person because then the max pages are way more than we need so we need to minimize this.
        return m >= 0 && m < stu;
    }
}
