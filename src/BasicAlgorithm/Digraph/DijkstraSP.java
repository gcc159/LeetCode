package BasicAlgorithm.Digraph;


import BasicAlgorithm.Digraph.DirectEdge;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraSP {
    private DirectEdge[] edgeTo;
    private double[] distTo;
    private Queue<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G,int s){
        edgeTo = new DirectEdge[G.V()];
        distTo = new double[G.V()];
        pq=new PriorityQueue<Double>(10,new Comparator<Double>(){
            @Override
            public int compare(Double o1, Double o2) {
                return 0;
            }
        });
        for(int v=0;v<G.V();v++)
            distTo[v]=Double.MAX_VALUE;
        distTo[s]=0.0;
        pq.offer(s,0.0);
    }
}
