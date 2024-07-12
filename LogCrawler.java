package Leetcode;

public class LogCrawler {
    public static void main(String[] args) {
        String[] logs={"./","../","./"};
        System.out.println(minOperations(logs));
    }
    public static int minOperations(String[] logs) {
        int folder=0;
        for(String log:logs){
            if(log.equals("../") ){
                if(folder!=0)
                folder--;
                else
                    folder=folder;
            }
            else if(log.equals("./"))folder=folder;
            else folder++;
        }
        return folder;
    }
}
