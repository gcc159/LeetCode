package Array.Major_Element_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candicate1=1,candicate2=0,count1=0,count2=0;
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candicate1)
                count1++;
            else if(nums[i]==candicate2)
                count2++;
            else if(count1==0)
                candicate1=nums[i];
            else if(count2==0)
                candicate2=nums[i];
            else{
                count1--;
                count2--;
            }

        }

        count1= 0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candicate1) count1++;
            if(nums[i]==candicate2) count2++;
        }
        if(count1>nums.length/3) res.add(candicate1);
        if(count2>nums.length/3) res.add(candicate2);

        return res;
    }

    public static void main(String[] args){
        int[] nums={8,9,8,9,8};
        Solution solution=new Solution();
        solution.majorityElement(nums);
    }
}
