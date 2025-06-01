import java.util.*;
public class ApplyOperationsToMaximizeScore {
    public static void main(String[] args) {
        ApplyOperationsToMaximizeScore as=new ApplyOperationsToMaximizeScore();
        Integer[] arr={3289,2832,14858,22011};
        List<Integer> list=new ArrayList<>(Arrays.asList(arr));
        System.out.println(as.maximumScore(list,6));
    }
    int modulo=1000000007;
    public int maximumScore(List<Integer> nums, int k) {
        int n=nums.size();
        long ans=1;
        Integer[] primeScore=new Integer[n];
        Integer[][] duplicate=new Integer[n][2];
        for(int i=0;i<n;i++){
            primeScore[i]=getPrimeScore(nums.get(i));
            duplicate[i][0]=nums.get(i);
            duplicate[i][1]=i;
        }
        Integer[] nextgreaterRight=getNextGreaterRight(primeScore);
        Integer[] prevSmallerOrEqualLeft=getPrevSmallerOrEqualLeft(primeScore);
        Arrays.sort(duplicate,(a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
            int ele=duplicate[i][0];
            int ind=duplicate[i][1];
            int canbeRepeated=Math.abs(ind-prevSmallerOrEqualLeft[ind])*Math.abs(ind-nextgreaterRight[ind]);
            if(canbeRepeated>=k){
                ans=(ans*findPower(ele,k))%modulo;
                k=0;
            }else{
                ans=(ans*findPower(ele,canbeRepeated))%modulo;
                k-=canbeRepeated;
            }
            if(k<=0){
                break;
            }
        }
        return (int)ans;
    }
    public Integer getPrimeScore(Integer num){
        Set<Integer> set=new HashSet<>();
        while(num%2==0){
            set.add(2);
            num/=2;
        }
        for(int j=3;j<=Math.sqrt(num);j=j+2){
            while(num%j==0){
                    set.add(j);
                    num/=j;
            }
        }
        if (num > 2)
            set.add(num);

        return set.size();
    }
    public Integer[] getNextGreaterRight(Integer[] list){
        int n=list.length;
        Stack<Integer> stack=new Stack<>();
        Integer[] ans=new Integer[n];
        for(int i= n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
                ans[i]=n;
                continue;
            }
            if(list[stack.peek()]<=list[i]){
                while(!stack.isEmpty() && list[stack.peek()]<=list[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=n;
                }else {
                    ans[i] = stack.peek();
                }
            }else{
                ans[i]=stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    public Integer[] getPrevSmallerOrEqualLeft(Integer[] list){
        int n=list.length;
        Stack<Integer> stack=new Stack<>();
        Integer[] ans=new Integer[n];
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(i);
                ans[i]=-1;
                continue;
            }
            if(list[stack.peek()]<list[i]){
                while(!stack.isEmpty() && list[stack.peek()]<list[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }else {
                    ans[i] = stack.peek();
                }
            }else{
                ans[i]=stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    public long findPower(long a,long b){
        if(b==0)return 1;
        long half=findPower(a,b/2);
        long result=(half*half)%modulo;
        if(b%2==1){
            result=(a*result)%modulo;
        }
        return result;
    }
}
