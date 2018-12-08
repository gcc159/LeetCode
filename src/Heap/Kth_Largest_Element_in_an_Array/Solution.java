package Heap.Kth_Largest_Element_in_an_Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> numsQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<nums.length;i++){
            numsQueue.offer(nums[i]);
        }
        int res=0;
        for(int i=0;i<k;i++)
            res=numsQueue.poll();
        return res;
    }
}
