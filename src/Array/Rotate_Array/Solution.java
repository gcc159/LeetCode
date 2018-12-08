package Array.Rotate_Array;

public class Solution {
    public void rotate(int[] nums, int k) {
        k=k %nums.length;
        rotate(nums,k,0,nums.length-1);

    }
    public void rotate(int []nums,int k,int left,int right){
        int total=right-left+1;
        int changenum=Math.min(k,total/2);
        if(k==0||left==right) return;
        if(k<=total/2){
            for(int i=0;i<k;i++){
                int temp=nums[left+i];
                nums[left+i]=nums[right+1-k+i];
                nums[right+1-k+i]=temp;

            }
            if(k*2<total)
                rotate(nums,k,left+k,right);
        }else{
            int t=right-left+1-k;
            for(int i=0;i<t;i++){
                int temp=nums[left+i];
                nums[left+i]=nums[right+1-t+i];
                nums[right+1-t+i]=temp;
            }
            rotate(nums,k-t,left,right-t);
        }
    }

    public static void main(String []args){
        int []nums={1,2,3,4,5,6,7};
        Solution solution=new Solution();
        solution.rotate(nums,3);
    }
}
