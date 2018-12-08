package Array.Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Stack<Integer> numStack=new Stack<Integer>();
        Stack<Integer> indexStack=new Stack<>();
        Arrays.sort(candidates);
        Integer sum=candidates[0];
        int currentIndex=0;

        numStack.push(candidates[0]);
        indexStack.push(0);


        List<List<Integer>> res=new ArrayList<>();
        if(sum>target) return res;
        while(!numStack.empty()){
            if(sum>=target){
                if(sum==target){
                    List<Integer> result=putIntoList(numStack);
                    res.add(result);
                }
                sum-=numStack.pop();
                indexStack.pop();
                int previous=0;
                if(!numStack.empty()) {
                    currentIndex = indexStack.pop();
                    previous=numStack.pop();
                    sum -= previous;
                    currentIndex++;
                    while(currentIndex<candidates.length&&previous==candidates[currentIndex]) currentIndex++;
                    if(currentIndex<candidates.length) {
                        numStack.push(candidates[currentIndex]);
                        indexStack.push(currentIndex);
                        sum += candidates[currentIndex];
                    }

                }
            }else{
                if(currentIndex==candidates.length-1){
                    sum-=numStack.pop();
                    indexStack.pop();
                    if(!numStack.empty()) {
                        currentIndex=indexStack.pop();
                        int previous=numStack.pop();
                        sum-=previous;
                        currentIndex++;
                        while(currentIndex<candidates.length&&previous==candidates[currentIndex]) currentIndex++;
                        if(currentIndex<candidates.length) {
                            numStack.push(candidates[currentIndex]);
                            indexStack.push(currentIndex);
                            sum += candidates[currentIndex];
                        }
                    }

                }else{
                    currentIndex=indexStack.peek();
                    numStack.push(candidates[++currentIndex]);
                    indexStack.push(currentIndex);
                    sum+=candidates[currentIndex];
                }

            }
        }
        return res;


    }

    private List<Integer> putIntoList(Stack<Integer> stack){
        List<Integer> res=new ArrayList<>();
        stack.forEach((x)->res.add(x));
        return res;
    }

    public static void main(String[] args){
        int[] nums={4,4,2,1,4,2,2,1,3,
        6};
        int target=6;

        Solution solution=new Solution();
        System.out.println(solution.combinationSum2(nums,target).toString());
    }
}
