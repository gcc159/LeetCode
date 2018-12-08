package Array.Remove_Duplicates_From_Sorted_Array_ii;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int current=1;
        int index=1;

        while(count<nums.length){
           if(nums[index]==nums[index-1]){
                current++;
                index++;
           }else{
               if(current>2){
                   System.arraycopy(nums,index,nums,index-current+2,nums.length-count+1);
                   index=index-current+3;

               }else
                   index++;
               current=1;
           }
           count++;
        }
        if(current>2)
            return index-current+2;
        else
            return index;

    }
    public static void main(String[] args){
        int[] nums={1,1,1,2,2,3};
        Solution solution=new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }
}
