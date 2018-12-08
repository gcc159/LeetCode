package BasicAlgorithm.Digraph;

public class AcyclicSP {
    private DirectEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G,int s){

        edgeTo = new DirectEdge[G.V()];
        distTo = new double[G.V()];

        for(int v = 0;v<G.V();v++){
            distTo[v]=Double.MAX_VALUE;
        }
        distTo[s]=0;

    }
}
