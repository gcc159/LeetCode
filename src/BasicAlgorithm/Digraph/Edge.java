package BasicAlgorithm.Digraph;

import org.jetbrains.annotations.NotNull;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v,int w,double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }

    public double weight(){
        return this.weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if (vertex==v) return w;
        else if (vertex==w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(@NotNull Edge o) {
        if(this.weight()>o.weight()) return 1;
        else if(this.weight()<o.weight()) return -1;
        else return 0;
    }
}
