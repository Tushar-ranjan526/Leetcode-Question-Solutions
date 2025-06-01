import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        RussianDollEnvelopes re=new RussianDollEnvelopes();
        int[][] enevelopes={{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
        System.out.println(re.maxEnvelopes(enevelopes));
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        List<Integer> list=new ArrayList<>();
        list.add(envelopes[0][1]);int len=1,maxlen=1;
        for(int i=1;i<envelopes.length;i++){
            int h=envelopes[i][1];
            int w=envelopes[i][0];
            if(list.getLast()<h){
                list.add(envelopes[i][1]);
                len++;
            }else if(list.getLast()==h){
                continue;
            }
            else{
                int pos=givePosition(list,envelopes[i][1]);
                list.set(pos,envelopes[i][1]);
            }
            maxlen=Math.max(maxlen,len);
        }
        return maxlen;
    }

    public int givePosition(List<Integer> list,int h){
        int s=0,e=list.size()-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(list.get(mid)<=h ){
                s=mid+1;
            }else if(list.get(mid)>h){
                e=mid-1;
            }
        }
        return s;
    }
}
