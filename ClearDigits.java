import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        ClearDigits cd=new ClearDigits();
        String s="cb34";
        System.out.println(cd.clearDigits(s));
    }
    public String clearDigits(String s) {
        Stack<Character> stack=new Stack<>();
        Character[] ch={'1','2','3','4','5','6','7','8','9','0'};
        Set<Character> set=new HashSet<>(Arrays.asList(ch));
        for(int i=0;i<s.length();i++){
            char character=s.charAt(i);
            if(!set.contains(character)){
                stack.push(character);
                continue;
            }
            if(set.contains(character)){
                if(!stack.isEmpty() )
                    stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
