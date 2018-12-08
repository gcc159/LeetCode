package Array.Summary_Range;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int currentHead=nums[0];
        int currentTail=nums[0];

        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i]-currentTail)==1){
                currentTail=nums[i];
            }else{

                res.add(contructString(currentHead,currentTail));
                currentHead=currentTail=nums[i];
            }

        }
        res.add(contructString(currentHead,currentTail));

        return res;
    }

    private String contructString(int start,int end){
        StringBuilder sb=new StringBuilder();
        sb.append(start
        );
        if(start!=end){
            sb.append("->");
            sb.append(end);
        }
        return sb.toString();
    }
}
