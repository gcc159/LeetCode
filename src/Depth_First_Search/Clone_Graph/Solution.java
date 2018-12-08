package Depth_First_Search.Clone_Graph;

import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer,UndirectedGraphNode> nodeMap=new HashMap<>();
        UndirectedGraphNode newHead=new UndirectedGraphNode(node.label);
        nodeMap.put(node.label,newHead);
        DFS(nodeMap,node,newHead);
        return newHead;

    }

    private void DFS(Map<Integer,UndirectedGraphNode> generated
            ,UndirectedGraphNode node,UndirectedGraphNode newNode){
        Set<Integer> visitedNode=generated.keySet();
        for(UndirectedGraphNode neighbor:node.neighbors){
            //UndirectedGraphNode newNeighbor=null;
            if(visitedNode.contains(neighbor.label)){
                newNode.neighbors.add(generated.get(neighbor.label));
            }else{
                UndirectedGraphNode nextNode=new UndirectedGraphNode(neighbor.label);
                generated.put(neighbor.label,nextNode);
                newNode.neighbors.add(nextNode);
                DFS(generated,neighbor,nextNode);

            }
        }


    }

    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
}
