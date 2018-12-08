package DynamicProgramming;

public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int dp[]=new int[n>3?n+1:3];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++) {
            dp[i] = 0;
            for (int j = 0; j < n; j++)
                dp[i]+=dp[j]*dp[i-j-1];
        }
        return dp[n];
    }
}