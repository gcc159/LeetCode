package Array.Majority_Element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int  count=map.getOrDefault(nums[i],0);
            count++;
            map.put(nums[i],count);
        }
        int max=Integer.MIN_VALUE;
        for(Map.Entry entry:map.entrySet()){
            if((Integer)entry.getValue()>max){
                max=(Integer)entry.getValue();
            }

        }
        return max;
    }
}
