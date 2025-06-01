public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay cs=new CountAndSay();
        System.out.println(cs.countAndSay(4));
    }
    public String countAndSay(int n) {
        String res="";
        // base condition
        if(n==1){
            return "1";
        }
        // ek kam ke liye call kardo recursively.
        String say=countAndSay(n-1);
        for(int i=0;i<say.length();i++){
            int count=1;
            while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1)){
                count++;
                i++;
            }
            res+=Integer.toString(count)+Character.toString(say.charAt(i));
        }
        return res;
    }
}
