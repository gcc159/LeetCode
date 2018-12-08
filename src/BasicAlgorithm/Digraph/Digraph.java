package BasicAlgorithm.Digraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Digraph {
    private final int V;
    private int E;
    private List<List<Integer>> adj;
    public Digraph(int V){
        this.V=V;
        this.E=0;
        adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new LinkedList<>());

    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    private void addEdge(int v,int w){
        adj.get(v).add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj.get(v);
    }

    public Digraph reverse(){
        Digraph R=new Digraph(V);
        for(int v=0;v<V;v++)
            for(int w:adj.get(v))
                R.addEdge(w,v);
        return R;
    }
}
