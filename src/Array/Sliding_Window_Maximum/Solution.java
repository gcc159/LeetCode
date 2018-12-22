package Array.Sliding_Window_Maximum;

import BasicAlgorithm.BasicDataStructure.PriorityQueue.PriorityQueue;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private class Point implements Comparable<Point>{
        int index;
        int value;


        public Point(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Solution.Point o) {
            if(this.value!=o.value)
                return Integer.compare(this.value,o.value);
            else
                return -Integer.compare(this.index,o.index);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new int[0];
        if(k==1){
            return nums;
        }
        Point[][] allMax=new Point[nums.length][2];
        allMax[0][0]=new Point(-1,-1);
        allMax[0][1]=new Point(-1,-1);
        List<Point> points=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(allMax[0][0].index==-1||nums[i]>=allMax[0][0].value){
                allMax[0][1]=allMax[0][0];
                allMax[0][0]=new Point(i,nums[i]);
            }else if(allMax[0][1].index==-1||nums[i]>=allMax[0][1].value){
                allMax[0][1]=new Point(i,nums[i]);
            }
        }

        for(int i=1;i<=nums.length-k;i++){
            if(allMax[i-1][0].index==i-1){
                if(allMax[i-1][1].value<=nums[i+k-1]){
                    allMax[i][1]=allMax[i-1][1];
                    allMax[i][0]=new Point(i+k-1,nums[i+k-1]);

                    //添加对[i][1]的搜过过程
                }else{

                    allMax[i][0]=allMax[i-1][1];
                    Point point =new Point(-1,Integer.MIN_VALUE);
                    for(int j=i;j<i+k-1;j++){
                        if((nums[j]>=point.value&&nums[j]<allMax[i][0].value)){
                            point.value=nums[j];
                            point.index=j;
                        }
                    }
                    if(point.value>nums[i+k-1]){
                        allMax[i][1]=point;
                    }else
                        allMax[i][1]=new Point(i+k-1,nums[i+k-1]);
                }
            }else{
                if(allMax[i-1][0].value<=nums[i+k-1]){
                    allMax[i][1]=allMax[i-1][0];
                    allMax[i][0]=new Point(i+k-1,nums[i+k-1]);
                }else{
                    allMax[i][0]=allMax[i-1][0];
                    if(allMax[i-1][1].value<=nums[i+k-1]){
                        allMax[i][1]=new Point(i+k-1,nums[i+k-1]);
                    }else{
                        if(allMax[i-1][1].index==i-1){
                            Point point =new Point(-1,Integer.MIN_VALUE);
                            for(int j=i;j<=i+k-1;j++){
                                if((nums[j]>=point.value&&nums[j]<allMax[i][0].value)){
                                    point.value=nums[j];
                                    point.index=j;
                                }
                            }
                            allMax[i][1]=point;
                        }else{
                            allMax[i][1]=allMax[i-1][1];
                        }
                    }
                }
            }
        }
        int []res=new int[nums.length-k+1];
        for(int i=0;i<res.length;i++){
            res[i]=allMax[i][0].value;
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums={9,10,9,-7,-4,-8,2,-6};
        Solution solution=new Solution();
        solution.maxSlidingWindow(nums,5);

    }
}
