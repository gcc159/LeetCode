package Breadth_First_Search.Trapping_Rain_Water_II;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Solution {
    int [][]direction={{-1,0},{1,0},{0,-1},{0,1}};
    class Point implements Comparable{
        int x;
        int y;
        int weight;

        public Point(int x, int y,int weight) {
            this.x = x;
            this.y = y;
            this.weight=weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int compareTo(@NotNull Object o) {
            return Integer.compare(this.weight,((Point)o).weight);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length==0) return 0;
        boolean[][] isCoverd = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Point> priorityQueue=new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < heightMap.length ; i++){
            priorityQueue.add(new Point(i,0,heightMap[i][0]));
            isCoverd[i][0]=true;
            priorityQueue.add(new Point(i,heightMap[0].length-1,heightMap[i][heightMap[0].length-1]));
            isCoverd[i][heightMap[0].length-1]=true;
        }
        for (int j = 1; j < heightMap[0].length-1 ; j++){
            priorityQueue.add(new Point(0,j,heightMap[0][j]));
            isCoverd[0][j]=true;
            priorityQueue.add(new Point(heightMap.length-1,j,heightMap[heightMap.length-1][j]));
            isCoverd[heightMap.length-1][j]=true;
        }
        int maxLevel=Integer.MIN_VALUE;
        while(!priorityQueue.isEmpty()){
            Point current=priorityQueue.poll();
            maxLevel=Math.max(current.weight,maxLevel);
            for(int i=0;i<4;i++){
                int nextX=current.x+direction[i][0];
                int nextY=current.y+direction[i][1];
                if((nextX>=1&&nextX<heightMap.length-1)
                        &&(nextY>=1&&nextY<heightMap[0].length-1)
                &&!isCoverd[nextX][nextY]){
                    if(heightMap[nextX][nextY]<maxLevel){
                        res+=maxLevel-heightMap[nextX][nextY];
                    }
                    priorityQueue.add(new Point(nextX,nextY,heightMap[nextX][nextY]));
                    isCoverd[nextX][nextY]=true;
                }
            }
        }
        return res;
    }



    public static void main(String[] args){
        int [][]heightMap={{78,16,94,36},{87,93,50,22},{63,28,91,60},{64,27,41,27},{73,37,12,69},{68,30,83,31},{63,24,68,36}};
        Solution solution=new Solution();
        solution.trapRainWater(heightMap);

    }

}
