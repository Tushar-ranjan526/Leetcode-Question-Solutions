import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentPrime {
    public static void main(String[] args) {
        int[][] matrix={{1,1},{9,9},{1,1}};
        MostFrequentPrime mp=new MostFrequentPrime();
        System.out.println(mp.mostFrequentPrime(matrix));
    }
    public int mostFrequentPrime(int[][] mat) {
        Map<Integer,Integer> mpp=new HashMap<>();
        int frequent=-1;
        int ans=-1;
        for(int i=0;i<mat.length;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<mat[0].length;i++){
                retAllPrime(i,j,mat,list,"0",true,false,false,false,false,false,false,false);
                retAllPrime(i,j,mat,list,"0",false,true,false,false,false,false,false,false);
                retAllPrime(i,j,mat,list,"0",false,false,true,false,false,false,false,false);
                retAllPrime(i,j,mat,list,"0",false,false,false,true,false,false,false,false);
                retAllPrime(i,j,mat,list,"0",false,false,false,false,true,false,false,false);
                retAllPrime(i,j,mat,list,"0",false,false,false,false,false,true,false,false);
                retAllPrime(i,j,mat,list,"0",false,false,false,false,false,false,true,false);
                retAllPrime(i,j,mat,list,"0",false,false,false,false,false,false,false,true);
            }
            for(int num:list){
                mpp.put(num,mpp.getOrDefault(num,0)+1);
                int cnt=mpp.get(num);
                if(cnt>frequent){
                    frequent=cnt;
                    ans=num;
                }
            }

        }
        return (ans>10)?ans:-1;
    }
    public void retAllPrime(int i,int j,int[][] mat,List<Integer> list,String number,boolean up,boolean down,boolean left,boolean right,boolean upright,boolean upleft,boolean downright,boolean downleft){
        if(i<0 || j<0 || i>mat.length-1 || j>mat[0].length-1){
            return;
        }
        int num=Integer.parseInt(number)*10+mat[i][j];
        if(isPrime(num)){
            list.add(num);
        }
        if(up)
        retAllPrime(i-1,j,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);

        if(down)
        retAllPrime(i+1,j,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);

        if(left)
        retAllPrime(i,j-1,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);

        if(right)
        retAllPrime(i,j+1,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);

        if(upright)
        retAllPrime(i-1,j+1,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);

        if(upleft)
        retAllPrime(i-1,j-1,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);

        if(downright)
        retAllPrime(i+1,j+1,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);

        if(downleft)
        retAllPrime(i+1,j-1,mat,list,Integer.toString(num),up,down,left,right,upright,upleft,downright,downleft);
    }
    public boolean isPrime(int n){
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return (n>10);
    }
}
