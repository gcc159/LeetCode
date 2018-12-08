package Array.Search_in_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }

    private int search(int[] nums,int target,int first,int second){
        if(first>second) return -1;
        boolean continuity=false;
        if(nums[second]>nums[first])
            continuity=true;
        boolean inFirst=false;
        int mid=(first+second)/2;
        if(continuity){
            if(nums[first]>target||nums[second]<target) return -1;
            if(nums[mid]>target)
                return search(nums,target,first,mid-1);
            else if(nums[mid]<target)
                return search(nums,target,mid+1,second);
            else return mid;
        }else{
            if(nums[first]<target&&nums[second]>target) return -1;
            if(nums[mid]>target){
                if(nums[mid]<nums[first])
                    return search(nums,target,first,mid-1);
                else {
                    if(nums[first]<=target)
                        return search(nums,target,first,mid-1);
                    else
                         return search(nums, target, mid + 1, second);
                }
            }else if(nums[mid]<target){
                if(nums[mid]>nums[first])
                    return search(nums,target,mid+1,second);
                else {
                    if(nums[second]<target)
                        return search(nums,target,first,mid-1);
                    else
                        return search(nums,target,mid+1,second);
                }
            }
            else return mid;
        }

    }

    public static void main(String args[]){
        int[] nums={5,1,3};
        int target=3;
        Solution solution=new Solution();

        System.out.println(solution.search(nums,target));
    }
}
