package Backtracking.Permutation_Sequence;

import java.util.*;

public class Solution {
    int n;
    int k;
    int currentSum=0;
    String res;
    public String getPermutation(int n, int k) {
        this.n=n;
        this.k=k;
        backtracking(new ArrayList<Integer>(),new HashSet<Integer>());
        return res;
    }
    private  void backtracking(List<Integer> current, Set<Integer> used){
        if(currentSum>k) return;
        if(current.size()==n) {
            currentSum++;
            if(currentSum==k){
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<n;i++){
                    sb.append(current.get(i));
                }
                res=sb.toString();
            }
            return;
        }
        for(int i=1;i<=n;i++){
            if(!used.contains(i)){
                current.add(i);
                used.add(i);
                backtracking(current,used);
                current.remove(current.size()-1);
                used.remove(i);
            }
        }
    }



    public static void main(String[] args){
        Solution solution=new Solution();
        solution.getPermutation(3,3);
    }


}
