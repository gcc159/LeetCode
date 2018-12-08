package Depth_First_Search.Course_Schedule_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];

        List<List<Integer>> adjVertex=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            List<Integer> current=new ArrayList<>();
            adjVertex.add(current);
        }
        Queue<Integer> sortQueue=new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++){
            adjVertex.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                sortQueue.offer(i);
            }
        }
        int []allFinish= new int[numCourses];
        int currentPosition=0;
        if(numCourses==0) return allFinish;
        while(!sortQueue.isEmpty()){
            int currentVertex=sortQueue.poll();
            allFinish[currentPosition++]=currentVertex;
            for(Integer adj:adjVertex.get(currentVertex)){
                indegree[adj]-=1;
                if(indegree[adj]==0)
                    sortQueue.offer(adj);
            }
        }
        if(currentPosition==numCourses)
            return allFinish;
        else
            return new int[0];
    }
}
