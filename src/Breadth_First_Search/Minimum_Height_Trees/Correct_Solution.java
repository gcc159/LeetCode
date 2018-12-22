package Breadth_First_Search.Minimum_Height_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Correct_Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        List<List<Integer>> edgesList = new ArrayList<>();
       // Queue<Integer> queue=new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            edgesList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            edgesList.get(edges[i][0]).add(edges[i][1]);
            edgesList.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][1]]+=1;
            degree[edges[i][0]]+=1;
        }
        for(int i=0;i<n;i++){
            if(degree[i]==1) res.add(i);
        }

        while(n>2){
            n-=res.size();
            List<Integer> nextRes=new ArrayList<>();
            for(Integer current:res){
            Integer j=edgesList.get(current).get(0);
            edgesList.get(j).remove(current);
            if(edgesList.get(j).size()==1)
                nextRes.add(j);
            }
            res=nextRes;
        }

        return res;
    }

}
