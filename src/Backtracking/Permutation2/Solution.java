package Backtracking.Permutation2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean []used=new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        return backtracking(new ArrayList<Integer>(),nums,used);

    }
    private List<List<Integer>> backtracking(List<Integer> current,int []nums,boolean []used){
        boolean hasNext=false;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0&&!used[i]&&nums[i]==nums[i-1]) continue;
            used[i]=true;
            hasNext=true;
            current.add(nums[i]);
            res.addAll(backtracking(current,nums,used));
            current.remove(current.size()-1);
            used[i]=false;
        }
        if(!hasNext) {
            res.add(new ArrayList<>(current));
        }
        return res;
    }
}
