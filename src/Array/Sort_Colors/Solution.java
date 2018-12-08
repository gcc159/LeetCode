package Array.Sort_Colors;

public class Solution {
    public void sortColors(int[] nums) {
        int low=0,high=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i<high&&nums[i]==2){
                while(i<high&&nums[high]==2) high--;
                exch(nums,i,high);
                if(nums[i]==0){
                    while(low<i&&nums[low]==0) low++;
                    exch(nums,low,i);
                }
            }else if(i<=high&&nums[i]==0){
                while(low<i&&nums[low]==0) low++;
                exch(nums,low,i);
            }
        }
    }


    private static void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
