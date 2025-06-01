import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AssignElementsWithConstraints {
    public static void main(String[] args) {
        AssignElementsWithConstraints sd=new AssignElementsWithConstraints();
        int[] groups={1,1};
        int[] elements={1};
        int[] ans=sd.assignElements(groups,elements);
        System.out.println(Arrays.toString(ans));
    }
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<elements.length;i++){
            mpp.putIfAbsent(elements[i],i);
        }
        int[] assigned = new int[n];
        for (int i = 0; i < n; i++) {
            int ele=groups[i];
            int mini=Integer.MAX_VALUE;
            for(int j=1;j*j<=ele;j++){
                if(ele%j==0 && mpp.containsKey(j)){
                    mini=Math.min(mini,mpp.get(j));
                }
                if(ele%(ele/j)==0 && mpp.containsKey((ele/j))){
                    mini=Math.min(mini,mpp.get(ele/j));
                }
            }
            assigned[i]=(mini==Integer.MAX_VALUE)?-1:mini;
        }

        return assigned;
    }
}
