package Greedy.Gas_Station;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain=new int[gas.length];
        List<Integer> start=new ArrayList<>();
        PriorityQueue<Node> heap=new PriorityQueue<>();
        //remain[0]=gas[0]-cost[0];
        int less=0;
        for(int i=0;i<gas.length;i++){
            remain[i]=gas[i]-cost[i];
            less+=remain[i];
            if(remain[i]>0)
                heap.add(new Node(remain[i],i));
        }
        if(less<0) return -1;
        int total=heap.size();
        for(int i=0;i<total;i++){
            Node node=heap.poll();
            int current=0;
            boolean isSolution=true;
            for(int index=0;index<gas.length;index++){
                current+=(remain[(node.index+index)%gas.length]);
                if(current<0) {
                    isSolution=false;
                    break;
                }
            }
            if(isSolution) return node.index;
        }
        return -1;


    }

    class Node implements Comparable<Node>{
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(@NotNull Solution.Node o) {
            return -1*Integer.compare(this.val,o.val);
        }
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        int []gas={2};

        int []cost={2};
        int res=solution.canCompleteCircuit(gas,cost);
        System.out.println(res);
    }

}
