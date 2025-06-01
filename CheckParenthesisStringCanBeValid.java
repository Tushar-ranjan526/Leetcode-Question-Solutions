import java.util.Stack;

public class CheckParenthesisStringCanBeValid {
    public static void main(String[] args) {
        CheckParenthesisStringCanBeValid cv=new CheckParenthesisStringCanBeValid();
        System.out.println(cv.canBeValid("))()))","010100"));
    }
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0)return false;
        Stack<Integer> open=new Stack<>();
        Stack<Integer> openClose=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(locked.charAt(i)=='0'){
                openClose.push(i);
            }
            else if(locked.charAt(i)=='1' && ch==')'){
                if(!open.isEmpty())open.pop();
                else if(!openClose.isEmpty())openClose.pop();
                else{
                    return false;
                }
            }else{
                open.push(i);
            }
        }

        while(!open.isEmpty() && open.peek()<openClose.peek()){
            open.pop();
            openClose.pop();
        }

        return open.isEmpty();
    }
}
