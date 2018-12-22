package Array.Brust_Ballons;

public class Solution {
    public int maxCoins(int[] nums) {
        int []newNums=new int[nums.length+2];
        int n=nums.length;
        newNums[0]=newNums[nums.length+1]=1;
        for(int i=1;i<=nums.length;i++)
            newNums[i]=nums[i-1];
        int[][]dp=new int[newNums.length][newNums.length];
         for(int size=1;size<=n;size++){
            for(int start=0;start<newNums.length-size-1;start++){
                int max=Integer.MIN_VALUE;
                int end=start+size+1;
                for(int i=start+1;i<end;i++){
                    int current=dp[start][i]+dp[i][end]+newNums[start]*newNums[end]*newNums[i];
                    max=Math.max(max,current);
                }
                dp[start][end]=max;
            }
        }
        return dp[0][n+1];
    }

    public static void main(String[] args){
        int[] nums={3,1,5,8};
        Solution solution=new Solution();
        solution.maxCoins(nums);
    }


}
