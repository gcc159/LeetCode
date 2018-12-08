package Array.Find_the_Duplicate_Number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int left=1;

        int right=nums.length-1;
        boolean find=false;
        while(left<right){
            int mid=(right+left)/2;
            int lower=0;
            int higher=0;

            for(int i=0;i<nums.length;i++){
                if(nums[i]<mid) lower++;
                if(nums[i]>mid) higher++;
            }
            if(lower>mid-1)
                right=mid-1;
            else if(higher>nums.length-1-mid)
                left=mid+1;
            else return mid;
        }
        return left;
    }

    public static void main(String[] args){

        int []nums={3,1,3,4,2};
        Solution solution=new Solution();
        solution.findDuplicate(nums);
    }
}
