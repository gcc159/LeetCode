package Array.Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        dfs(candidates,0,target,path,res);
        return res;
    }

    private void dfs(int[] canditates,int curIndex,int target,List<Integer> path,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
        }
        if(target<0) return;
        for(int i=curIndex;i<canditates.length;i++){
            if(i>curIndex&&canditates[i]==canditates[i-1]) continue;
            path.add(path.size(),canditates[i]);
            dfs(canditates,i+1,target-canditates[i],path,res);
            path.remove(path.size()-1);

        }
    }
}
