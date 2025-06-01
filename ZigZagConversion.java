public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion zc=new ZigZagConversion();
        System.out.println(zc.convert("PAYPALISHIRING",3));
    }
    public String convert(String s, int numRows) {
        String[] str=new String[numRows];
        for(int i=0;i<str.length;i++){
            str[i]="";
        }
        int i=0;
        while(i<s.length()){
            for(int j=0;j<numRows;j++){
                str[j]+=s.charAt(i++)+"";
                if(i>=s.length())break;
            }
            if(i>=s.length())break;
            for(int j=str.length-2;j>0;j--){
                str[j]+=s.charAt(i++)+"";
                if(i>=s.length())break;
            }
        }
        String ans="";
        for(String word:str){
            ans+=word;
        }
        return ans;
    }
}
