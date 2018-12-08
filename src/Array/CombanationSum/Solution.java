package Array.CombanationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return search(k,n,10);

    }

    private List<List<Integer>> search(int k,int n ,int last){
        List<List<Integer>> res=new ArrayList<>();
        if(n>k*last||n<=0) return null;
        if(k==1&&n<last) {
            List<Integer> result=new ArrayList<>();
            result.add(n);
            res.add(result);
            return res;
        }
        for(int i=last-1;i>=1;i--){
            List<List<Integer>> current=search(k-1,n-i,i);
            if(current!=null) {
                for (List<Integer> list : current
                )
                    list.add(i);
                res.addAll(current);
            }
        }
        return res;
    }

}
