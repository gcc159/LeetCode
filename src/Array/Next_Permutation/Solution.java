package Array.Next_Permutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        for(int i=nums.length-1;i>0;i--){
                if(nums[i-1]<nums[i]){
                    int min=nums[i];
                    int minj=i;
                    for(int j=i;j<nums.length;j++){
                        if(nums[j]<min&&nums[j]>nums[i-1]){
                            min=nums[j];
                            minj=j;
                        }
                    }

                    int temp=nums[i-1];
                    nums[i-1]=min;
                    nums[minj]=temp;

                    Arrays.sort(nums,i,nums.length);
                    return;
                }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args){
        int[] nums={1,3,2};
        Solution solution=new Solution();

        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }


}
