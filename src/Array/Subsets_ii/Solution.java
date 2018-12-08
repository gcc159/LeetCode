package Array.Subsets_ii;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer,Integer> map=new TreeMap<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            Integer count=map.getOrDefault(nums[i],0);
            count++;
            map.put(nums[i],count);
        }
        Iterator iter=map.entrySet().iterator();
        res.add(new ArrayList<>());
        while(iter.hasNext()){

            Map.Entry entry=(Map.Entry)iter.next();
            List<List<Integer>> currentMapTotal=new ArrayList<>();
            for(int k=0;k<res.size();k++) {
                    List<Integer> list=res.get(k);
                    List<List<Integer>> currentTotal = new ArrayList<>();
                    for (int i = 1; i < (Integer) entry.getValue(); i++) {
                        List<Integer> currentList = new ArrayList<>(list);
                        for (int j = 0; j < i; j++) {
                            currentList.add((Integer) entry.getValue());
                        }
                        currentTotal.add(currentList);
                    }
                    currentMapTotal.addAll(currentTotal);
            }

            res.addAll(currentMapTotal);
        }
        return res;
    }
}
