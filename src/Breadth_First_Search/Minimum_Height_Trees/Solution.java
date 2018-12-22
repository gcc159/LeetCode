package Breadth_First_Search.Minimum_Height_Trees;

import javafx.scene.layout.Priority;

import java.util.*;

public class Solution {
    class Direction{
        int from;
        int to;


        @Override
        public boolean equals(Object obj) {
            if(obj.getClass()!=this.getClass()) return false;
            return this.from==((Direction)obj).from&&this.to==((Direction)obj).to;
        }

        public Direction(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    class Point {
        int index;
        int degree;

        public Point(int index,int degree) {
            this.index = index;
            this.degree=degree;
        }
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Direction,Integer> heightMap=new HashMap<>();
        int []degree=new int[n];
        List<List<Integer>> edgesList=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        for(int i=0;i<n;i++){
            edgesList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            edgesList.get(edges[i][0]).add(edges[i][1]);
            edgesList.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][1]]+=1;
            degree[edges[i][0]]+=1;
        }

        PriorityQueue<Point> priorityQueue=new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.degree!=o2.degree)
                    return Integer.compare(o2.degree,o1.degree);
                else
                    return Integer.compare(o1.index,o2.index);
            }
        });

        for(int i=0;i<n;i++){
            if(degree[i]>1)
                priorityQueue.add(new Point(i,degree[i]));
        }

        int minHeight=Integer.MAX_VALUE;
        while(!priorityQueue.isEmpty()){
            Point point=priorityQueue.poll();
            int height=getHeight(point.index,-1,heightMap,edgesList);
            if(height<minHeight){
                res.clear();
                res.add(point.index);
                minHeight=height;

            }else if(height==minHeight){
                res.add(point.index);
            }
        }
        if(res.isEmpty()){
            for(int i=0;i<n;i++)
                res.add(i);
        }
        return res;
    }


    private int getHeight(int current,int from,
                          Map<Direction,Integer> heightMap,List<List<Integer>> edges){
        int height=0;
        for(int x:edges.get(current)){
            if(x!=from){
                Direction direction=new Direction(current,x);
                int currentHeight;
                if(heightMap.containsKey(direction)){
                    currentHeight=heightMap.get(direction);
                }else{
                    currentHeight=getHeight(x,current,heightMap,edges);
                    heightMap.put(direction,currentHeight);
                }
                height=Math.max(height,currentHeight);
            }
        }
        return height+1;

    }


}
