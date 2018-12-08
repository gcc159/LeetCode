package Depth_First_Search.Course_Schedule;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int allFinish=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                sortQueue.offer(i);
            }
        }
        while(!sortQueue.isEmpty()){
            int currentVertex=sortQueue.poll();
            allFinish++;
            for(Integer adj:adjVertex.get(currentVertex)){
                indegree[adj]-=1;
                if(indegree[adj]==0)
                    sortQueue.offer(adj);
            }
        }
        return allFinish==numCourses;
    }
}
