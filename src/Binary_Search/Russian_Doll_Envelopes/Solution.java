package Binary_Search.Russian_Doll_Envelopes;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Point []points=new Point[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            Point point=new Point(envelopes[i][0],envelopes[i][1]);
            points[i]=point;
        }

        Arrays.sort(points);
        int []dp=new int[envelopes.length];
        Arrays.fill(dp,1);
        int res=0;
        for(int i=1;i<envelopes.length;i++){
            for(int j=i-1;j>=0;j--)
                if(points[i].x>points[j].x&&points[i].y>points[j].y)
                    dp[i]=Math.max(dp[i],dp[j]+1);
        }
        for(int i=0;i<envelopes.length;i++)
            res=Math.max(res,dp[i]);
        return res;


    }
    class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(@NotNull Solution.Point o) {
            if(this.x==o.x){
                return Integer.compare(this.y,o.y);
            }else
                return Integer.compare(this.x,o.x);
        }
    }
}
