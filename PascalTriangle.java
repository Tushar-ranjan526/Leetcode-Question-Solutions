public class PascalTriangle {
    public static void main(String[] args) {
        createPascalTriangle(4);
    }
    public static void createPascalTriangle(int r){
        for(int i=0;i<r;i++){
            for(int space=r-i;space>=0;space--){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print(retPascal(i,j)+" ");
            }
            System.out.println();
        }
    }
    public static long retPascal(int r,int c){
        long res=1;
        for(int i=0;i<c;i++){
            res*=(r-i);
            res/=(i+1);
        }
        return res;
    }

}
