package Array.Trapping_Rain_Water;

public class CurrentSolution {
    public int trap(int[] height) {
        int leftMax=height[0];
        int rightMax=height[height.length-1];
        int left=0;
        int right=height.length-1;
        int res=0;
        while(left<right){
            while(height[left]<=rightMax&&left<right){
                leftMax=Math.max(leftMax,height[left]);
                res+=leftMax-height[left];

                left++;
            }
            leftMax=Math.max(leftMax,height[left]);
            while(height[right]<=leftMax&&left<right){
                rightMax=Math.max(rightMax,height[right]);
                res+=rightMax-height[right];

                right--;
            }
            rightMax=Math.max(rightMax,height[right]);
        }
        return res;
    }

    public static void main(String[] args){
        int []nums={0,1,0,2,1,0,1,3,2,1,2,1};
        CurrentSolution solution=new CurrentSolution();
        solution.trap(nums);
    }
}
