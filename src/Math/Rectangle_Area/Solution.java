package Math.Rectangle_Area;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        Point []allPoints= new Point[4];
        int allArea=(C-A)*(D-B)+(G-E)*(H-F);
        allPoints[0]=new Point(A,B,true,true);
        allPoints[1]=new Point(C,D,true,false);

        allPoints[2]=new Point(E,F,false,true);
        allPoints[3]=new Point(G,H,false,false);

        Arrays.sort(allPoints);

        if(allPoints[0].isFrist==allPoints[1].isFrist) return allArea;
        int resX=allPoints[2].x-allPoints[1].x;
        for(int i=0;i<4;i++)
            allPoints[i].x=0;
        Arrays.sort(allPoints);
        if(allPoints[0].isFrist==allPoints[1].isFrist) return allArea;
        int resY=allPoints[2].y-allPoints[1].y;
        return allArea-resX*resY;

    }

    public class Point implements Comparable<Point>{
        int x;
        int y;
        boolean isFrist;
        boolean isLeft;


        public Point(int x, int y, boolean isFrist,boolean isLeft) {
            this.x = x;
            this.y = y;
            this.isFrist = isFrist;
            this.isLeft = isLeft;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x!=o.x)
                return this.x-o.x;
            else return this.y-o.y;
        }
    }
}
