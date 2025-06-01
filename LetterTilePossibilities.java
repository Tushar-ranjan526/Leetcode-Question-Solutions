import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        LetterTilePossibilities lp=new LetterTilePossibilities();
        System.out.println(lp.numTilePossibilities("AAABBC"));
    }
    public int numTilePossibilities(String tiles) {
        Set<String> set=new HashSet<>();
        retAllPossibilities(tiles,"",set);
        return set.size();
    }
    public void retAllPossibilities(String tiles,String curr,Set<String> set){
        if(tiles.isEmpty()){
            return;
        }
        if(tiles.length()==1){
            set.add(curr+tiles);
            return;
        }
        for(int i=0;i<tiles.length();i++){
            String newtile=tiles.substring(0,i)+tiles.substring(i+1);
            String current=tiles.substring(i,i+1)+curr;
            set.add(current);
            retAllPossibilities(newtile,current,set);
        }
        return;
    }
}
