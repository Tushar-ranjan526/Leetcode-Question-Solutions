import java.util.Arrays;

public class SolvingQuestionsWithBrainPowers {
    public static void main(String[] args) {
        SolvingQuestionsWithBrainPowers sp=new SolvingQuestionsWithBrainPowers();
        int[][] questions={{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(sp.mostPoints(questions));
    }
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        return getMaxPoints(0,questions,dp);
    }
    public long getMaxPoints(int i,int[][] questions,long[] dp){
        if(i>=questions.length){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];

        long ans=0;

        ans=questions[i][0]+getMaxPoints(i+questions[i][1]+1,questions,dp);
        ans=Math.max(ans,getMaxPoints(i+1,questions,dp));
        return dp[i]=ans;
    }
}
