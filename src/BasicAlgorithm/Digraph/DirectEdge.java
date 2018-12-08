package BasicAlgorithm.Digraph;

public class DirectEdge {
    private final int v;
    private final int w;
    private final double weight;

    public DirectEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return this.weight;
    }

    public int from(){
        return this.v;
    }

    public int to(){
        return this.w;
    }

    public String toString(){
        return String.format("%d->%d %.2f",v,w,weight);
    }
}
