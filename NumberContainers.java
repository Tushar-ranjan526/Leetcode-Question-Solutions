import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class NumberContainers {
        Map<Integer, Set<Integer>> numbermap;
        Map<Integer,Integer> indexmap;

        public NumberContainers() {
            numbermap=new HashMap<>();
            indexmap=new HashMap<>();
        }

        public void change(int index, int number) {
            if(indexmap.containsKey(index)){
                int currnum=indexmap.get(index);
                if(currnum==number)return;
                Set<Integer> pq=numbermap.get(currnum);
                pq.remove(index);
                numbermap.put(currnum,pq);
            }
            if(numbermap.containsKey(number)){
                Set<Integer> pq=numbermap.get(number);
                pq.add(index);
                numbermap.put(number,pq);
                indexmap.put(index,number);
                return;
            }
            Set<Integer> pq=new HashSet<>();
            pq.add(index);
            numbermap.put(number,pq);
            indexmap.put(index,number);
        }

        public int find(int number) {
            if(!numbermap.containsKey(number)){
                return -1;
            }
            Set<Integer> pq=numbermap.get(number);
            if(pq.isEmpty()){
                numbermap.remove(number);
                return -1;
            }
            int mini=Integer.MAX_VALUE;
            for(int num:pq){
                mini=Math.min(num,mini);
            }
            return mini;
        }


}
