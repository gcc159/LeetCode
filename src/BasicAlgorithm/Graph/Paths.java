package BasicAlgorithm.Graph;

public abstract class Paths {
    Paths(Graph G,int s){};

    abstract boolean hasPathTo(int v);

    abstract Iterable<Integer> pathTo(int v);


}
