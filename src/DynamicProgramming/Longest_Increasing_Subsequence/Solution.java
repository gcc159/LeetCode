package DynamicProgramming.Longest_Increasing_Subsequence;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        int[] res=new int[nums.length];
        res[0]=1;
        int result=1;
        for(int i=1;i<nums.length;i++){
            res[i]=1;
            for(int j=0;j<i;i++)
                if(nums[j]<nums[i]){
                    res[i]=Math.max(res[i],res[j]+1);
                }
             result=Math.max(result,res[i]);
        }
        return result;
    }
}
