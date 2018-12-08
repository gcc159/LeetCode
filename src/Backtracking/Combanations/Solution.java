package Backtracking.Combanations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    int k=0;
    int n=0;
    public List<List<Integer>> combine(int n, int k) {
        this.k=k;
        this.n=n;
        //boolean[] used=new boolean[n];
        //Arrays.fill(used,false);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        for(int i=1;i<=n-k+1;i++){
            current.add(i);
            res.addAll(backtracking(current));
            current.remove(0);
        }
        return res;
    }

    private List<List<Integer>> backtracking(List<Integer> current){
        List<List<Integer>> res=new ArrayList<>();
        if(current.size()==k){
            res.add(new ArrayList<Integer>(current));
            return res;
        }else{
            for(int i=current.get(current.size()-1)+1;i<=n;i++){

                    current.add(i);
                    res.addAll(backtracking(current));
                    current.remove(current.size()-1);
            }
            return res;
        }
    }
}
