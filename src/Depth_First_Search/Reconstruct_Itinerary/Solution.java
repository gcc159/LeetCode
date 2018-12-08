package Depth_First_Search.Reconstruct_Itinerary;

import java.util.*;

public class Solution {
    Map<String, PriorityQueue<String>> adjs=new HashMap<>();
    List<String> path=new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {


        for(int i=0;i<tickets.length;i++){
            String start=tickets[i][0];
            String end=tickets[i][1];
            PriorityQueue<String> adj=adjs.getOrDefault(start,new PriorityQueue<>());
            adj.add(end);
            adjs.put(start,adj);

        }


       dfs("JFK");
        return path;
    }

    private void dfs(String current){
        PriorityQueue<String> priorityQueue=adjs.get(current);
        while(priorityQueue!=null&&!priorityQueue.isEmpty()){
            dfs(priorityQueue.poll());
        }
        path.add(0,current);

    }

    public static void main(String[] args){
        String[][] input={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        Solution solution=new Solution();
        solution.findItinerary(input);
    }
}
