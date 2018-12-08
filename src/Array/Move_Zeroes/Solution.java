package Array.Move_Zeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex=0;
        int notZeroIndex=0;
        while(zeroIndex!=nums.length||notZeroIndex!=nums.length){
            while(zeroIndex<nums.length&&nums[zeroIndex]!=0) zeroIndex++;
            while(notZeroIndex<nums.length&&!(nums[notZeroIndex]!=0&&notZeroIndex>zeroIndex))  notZeroIndex++;
            if(zeroIndex<nums.length&&notZeroIndex<nums.length){
                int temp=nums[zeroIndex];
                nums[zeroIndex]=nums[notZeroIndex];

                nums[notZeroIndex]=temp;

            }

        }
    }



    public static void main(String[] args){
        int[] nums={0,1,0,3,12};

        Solution solution=new Solution();
        solution.moveZeroes(nums);
    }
}