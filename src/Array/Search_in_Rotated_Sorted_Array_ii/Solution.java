package Array.Search_in_Rotated_Sorted_Array_ii;

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        if(nums.length==1) return nums[0]==target;
        boolean res=false;
        int []no_dup=new int[nums.length];
        no_dup[0]=nums[0];
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=no_dup[index]) no_dup[++index]=nums[i];
        }
        if(no_dup[0]==no_dup[index]&&index>0) index--;
        int low=0,high=index;
        nums=no_dup;

        while(low<=high){
            boolean isContinous=(nums[high]>=nums[low]);
            if(low==high) return nums[high]==target;
            int mid=(high+low)/2;
            if(isContinous){
                if(nums[high]<target||nums[low]>target) break;
                if(nums[mid]==target){
                    res=true;
                    break;
                }else if(nums[mid]<target) low=mid+1;
                else high=mid-1;
            }else{
                if(nums[mid]==target){
                    res=true;
                    break;
                }else if(nums[mid]>target){
                    if(nums[mid]>=nums[low]) {
                        if(nums[low]<=target)
                            high=mid-1;
                        else if(nums[high]>=target) low=mid+1;
                        else break;
                    }
                    else high=mid-1;
                }else if(nums[mid]<target){
                    if(nums[mid]>=nums[low]) low=mid+1;
                    else {
                        if(nums[high]>=target) low=mid+1;
                        else if(nums[low]<=target) high=mid-1;
                        else break;
                    }
                }
            }

        }
        return res;
    }
    public static void main(String[] args){
        int []nums={3,1};
        Solution solution=new Solution();
        System.out.println(solution.search(nums,0));
    }
}
