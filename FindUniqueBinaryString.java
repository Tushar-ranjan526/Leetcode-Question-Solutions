import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public static void main(String[] args) {
        FindUniqueBinaryString fubns=new FindUniqueBinaryString();
        String[] nums={"111","011","001"};
        System.out.println(fubns.findDifferentBinaryString(nums));
    }
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(String num:nums){
            set.add(convertInNumber(num));
        }
        StringBuilder sb=new StringBuilder();
        return retAllString(sb,n,set);
    }
    public int convertInNumber(String num){
        int ans=0,i=num.length()-1,pow=0;
        while(i>=0){
            int last=Integer.parseInt(num.substring(i,i+1));
            ans=ans+last*(int)(Math.pow(2,pow));
            num=num.substring(0,i);
            pow++;
            i--;
        }
        return ans;
    }
    public String retAllString(StringBuilder sb,int len,Set<Integer> set){
        if(sb.length()==len){
            if(!set.contains(convertInNumber(sb.toString()))){
                String ans=sb.toString();
                return ans;
            }
            return "";
        }
        String ans="";
        for(int i=0;i<=1;i++){
            sb.append(i);
            ans=retAllString(sb,len,set);
            if(ans.length()==len)return ans;
            sb.deleteCharAt(sb.length()-1);
        }
        return ans;
    }
}
