import java.util.Stack;

public class ClumsyFactorial {
    public static void main(String[] args) {
        ClumsyFactorial cf=new ClumsyFactorial();
        System.out.println(cf.clumsy(10));
    }
    public int clumsy(int n) {
        char[] arr=new char[4];
        arr[0]='*';arr[1]='/';arr[2]='+';arr[3]='-';
        Stack<Integer> stack=new Stack<>();
        for(int i=1;i<=n;i++){
            stack.push(i);
        }
        int i=0,ans=stack.pop();
        while(!stack.isEmpty()){
            if(arr[i]=='*'){
                ans*=stack.pop();
            }
            else if(arr[i]=='/'){
                ans=(int)Math.floor(ans/stack.pop());
            }
            else if(arr[i]=='+'){
                ans+=stack.pop();
            }
            else{
                ans-=stack.pop();
            }
            i=((i+1)%arr.length);
        }
        return ans;
    }
}
