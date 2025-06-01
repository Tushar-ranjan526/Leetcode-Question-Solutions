import java.util.Arrays;
// codestorywithmik differnce array technique : r+1 kyu kiya? cummulative sum.
public class ShiftingLettersII {
    public static void main(String[] args) {
        ShiftingLettersII sl=new ShiftingLettersII();
//        int[][] shifts={{4,8,0},{4,4,0},{2,4,0},{2,4,0},{6,7,1},{2,2,1},{0,2,1},{8,8,0},{1,3,1}};
        int[][] shifts={{0,1,0},{1,2,1},{0,2,1}};
        System.out.println(sl.shiftingLetters("abc",shifts));
    }
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb=new StringBuilder();
        int[] arr=new int[s.length()];
        for(int i=0;i<shifts.length;i++){
            int l=shifts[i][0];
            int r=shifts[i][1];
            int dir=shifts[i][2];
            if(dir==1) {
                // baad mei lagataar sum karte jaaunga isiliye pehle waale ko utna add kiya .
                // aur last ke ek baad waale ko utna subtract kiya taaki lagaatar sum karu to add hote hote jaha tak karna tha uske
                // baad 0 ho jaaye
                // for e.g. 0th se 1st tak 1 add karna hai to for loop lagane ke bajaye 0th mei 1 add kiya
                // aur 1st ke baad yaani 2nd mei -1 add kiya
                // to ab agar sum kiya to 0th ka 1 fir 1st to zero tha to usme pehle waala 1 add kiya to wo bhi 1
                // then 2nd waale mei 1 add kiya pehle waala to -1 +1 =0 ho gaya.
                arr[l]+=1;
                if(r+1<arr.length)arr[r+1]-=1;
            }else{
                arr[l]-=1;
                if(r+1<arr.length)arr[r+1]+=1;
            }
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            arr[i]=sum;
        }
        for(int i=0;i<arr.length;i++){
            int ch=s.charAt(i)-'a';
            int toshifts=(ch+arr[i])%26;
            if(toshifts<0){
                toshifts=26+toshifts;
            }
            sb.append((char)(toshifts+'a'));
        }
        return sb.toString();
    }
}
