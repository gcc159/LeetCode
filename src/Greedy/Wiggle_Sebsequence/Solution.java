package Greedy.Wiggle_Sebsequence;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        LinkedList<Integer> sub = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i] - nums[i - 1];
            if (current == 0)
                continue;
            else {
                if (sub.size()==0||(current > 0 && (sub).getLast() < 0) || (current < 0 && (sub).getLast() > 0))
                    sub.add(current);
                else {
                    Integer tail = sub.getLast();

                    tail += current;
                }

            }
        }
        return sub.size() + 1;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        int [] nums={1,7,4,9,2,5};
        solution.wiggleMaxLength(nums
                );
    }

}
