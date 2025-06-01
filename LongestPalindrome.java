import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome lp=new LongestPalindrome();
        System.out.println(lp.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
    public int longestPalindrome(String s) {
        int largestOdd=Integer.MIN_VALUE;
        Map<Character,Integer> mpp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry:mpp.entrySet()){
            if(entry.getValue()%2!=0){
                largestOdd=Math.max(largestOdd,entry.getValue());
            }
        }
        int ans=0;
        for(Map.Entry<Character,Integer> entry:mpp.entrySet()){
            int curr=entry.getValue();
                if(curr%2==0)ans+=curr;
                else if(curr%2!=0){
                    if(curr!=largestOdd)ans+=curr-1;
                    else {
                        ans += curr;
                        largestOdd=Integer.MAX_VALUE;
                    }
                }
        }
        return ans;
    }
}
