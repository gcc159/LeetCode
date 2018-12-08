package BasicAlgorithm.Searching.HashTable;

import java.util.TreeMap;

@SuppressWarnings("unchecked")
public class SeparateChainHashST<Key,Value> {
    private int N;
    private int M;
    private TreeMap<Key,Value>[] st;

    public SeparateChainHashST(){
        this(997);
    }

    public SeparateChainHashST(int M){
        this.M=M;
        st=(TreeMap<Key,Value>[]) new TreeMap[M];
        for (int i=0;i<M;i++){
          //  st[i]=new SequentialSearchST();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key,Value val){
        st[hash(key)].put(key,val);
    }


}
