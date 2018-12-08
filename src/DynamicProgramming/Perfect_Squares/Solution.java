package DynamicProgramming.Perfect_Squares;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        if(n==1) return 1;
        while(n%4==0) n/=4;
        int []res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        for(int i=1;i*i<=n; i++){
            res[i*i]=1;
        }

        for(int i=1;i<=n;i++){
            if(res[i]==1)
                continue;
            else
                for(int j=1;j<=i-1;j++)
                    res[i]=Math.min(res[i],res[j]+res[i-j]);
        }

        return res[n];
    }
}
