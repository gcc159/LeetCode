package Backtracking.Permutations;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> allSet=new TreeSet<>();
        for(int i=0;i<nums.length;i++)
            allSet.add(nums[i]);
        return backtracking(allSet,new ArrayList<Integer>());
    }


    private List<List<Integer>> backtracking(Set<Integer> currentSet,List<Integer> currentList){
        List<List<Integer>> res=new ArrayList<>();
        if(currentSet.isEmpty()) {
            res.add(new ArrayList<>(currentList));
            return res;
        }else{
            Integer[] numsArray=currentSet.toArray(new Integer[currentSet.size()]);
            for(int i=0;i<numsArray.length;i++){
                Integer item=numsArray[i];
                currentList.add(item);
                currentSet.remove(item);
                res.addAll(backtracking(currentSet,currentList));
                currentList.remove(item);
                currentSet.add(item);
            }
            return res;
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        Solution solution=new Solution();
        solution.permute(nums);
    }
}
