public class PunishmentOfAnInteger {
    public static void main(String[] args) {
        PunishmentOfAnInteger pi=new PunishmentOfAnInteger();
        System.out.println(pi.punishmentNumber(10));
    }
    public int punishmentNumber(int n) {
        if(n==1){
            return 1;
        }
        int sum=0;
        int square=retSquare(n);
        int indSum=retIndividualSum(Integer.toString(square),0,n);
        if(indSum==n){
            sum+=square;
        }
        sum+=punishmentNumber(n-1);
        return sum;
    }
    public int retSquare(int n){
        return n*n;
    }
    public int retIndividualSum(String num,int sum,int original){
       if(num.length()==1){
           return Integer.parseInt(num);
       }
       if(num.length()<=0){
           return 0;
       }
       for(int i=0;i<num.length();i++){
           int curr=Integer.parseInt(num.substring(0,i+1));
           int sumupto=retIndividualSum(num.substring(i+1),curr+sum,original);
           if(sum+curr+sumupto==original){
               return curr+sumupto;
           }
       }
       return 0;
    }
}
