package DynamicProgramming.MaximumProductSubarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp=new int[nums.length][2];
        boolean hasZero=false;
        if(nums[0]>0)
            dp[0][0]=nums[0];
        else if(nums[0]<0)
            dp[0][1]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
                dp[i][0]=dp[i-1][0]*nums[i]>nums[i]?dp[i-1][0]*nums[i]:nums[i];
                dp[i][1]=dp[i-1][1]*nums[i]<0?dp[i-1][1]*nums[i]:0;
            }else if(nums[i]<0){
                dp[i][0]=dp[i-1][1]*nums[i]>0?dp[i-1][1]*nums[i]:0;
                dp[i][1]=dp[i-1][0]*nums[i]<nums[i]?dp[i-1][1]*nums[i]:nums[i];
            }else{
                hasZero=true;
                dp[i][0]=dp[i][1]=0;
            }
        }
        int res=0;
        for(int i=0;i<nums.length;i++)
            if(dp[i][0]>res) res=dp[i][0];
        if(!hasZero&&res==0) res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
            if(dp[i][1]>res) res=dp[i][1];
        return res;
    }

    public static void main(String[] args){


    }
}
