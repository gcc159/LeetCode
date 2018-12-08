package BasicAlgorithm.Graph;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int V;
    private int E;

    private List[] adj;

    public Graph(int V){
        this.V=V;
        this.E=0;
        adj=new List[V];

        for(int v=0;v<V;v++)
            adj[v]=new LinkedList<Integer>();

    }

    public Graph(DataInputStream in) throws Exception{
        this(in.readInt());
        int E = in.readInt();
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(v);
        adj[w].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }




    public static int degree(Graph G,int v){
        int degree=0;
        for(int w:G.adj(v)) degree++;
        return degree;
    }
    public static int maxDegree(Graph G){
        int max=0;
        for(int v=0;v<G.V();v++){
            if(degree(G,v)>max)
                max=degree(G,v);
        }
        return max;
    }

    public static double avgDegree(Graph G){
        return 2.0*G.E()/G.V();
    }

    public static int numberOfSelfLoops(Graph G){

        int count=0;
        for(int v=0;v<G.V();v++){
            for (int w:G.adj(v))
                if(v==w) count++;
        }
        return count/2;
    }



}
