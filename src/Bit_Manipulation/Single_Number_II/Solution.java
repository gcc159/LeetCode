package Bit_Manipulation.Single_Number_II;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final int INITIAL_SCORE=3;
    public int singleNumber(int[] nums) {
        Integer [] candidate=new Integer[4];
        Arrays.fill(candidate,null);
        int []candidateScore=new int[4];
        for(int i=0;i<nums.length;i++){
            boolean isEnd=false;
            for(int j=0;j<4;j++){

                if(candidate[j]!=null&&candidate[j]==nums[i]){
                    candidateScore[j]--;
                    isEnd=true;
                    break;
                }

            }
            if(isEnd) continue;
            for(int j=0;j<4;j++){
                if(candidate[j]==null){
                    candidate[j]=nums[i];
                    candidateScore[j]=INITIAL_SCORE;
                    isEnd=true;
                    break;
                }
            }
            if(isEnd) continue;
            int min=Integer.MAX_VALUE;
            int minIndex=-1;
            for(int j=0;j<4;j++){
                if(candidateScore[j]<min){
                    minIndex=j;
                    min=candidateScore[j];
                }
            }
            if(min<INITIAL_SCORE) {
                candidate[minIndex] = nums[i];
                candidateScore[minIndex] = INITIAL_SCORE;
            }
        }

        int max=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<4;i++){
            if(candidateScore[i]>max){
                max=candidateScore[i];
                res=candidate[i];
            }
        }
        return res;

    }

    public static void main(String[] args){
        int []nums={-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555};
        Solution solution=new Solution();
        int res=solution.singleNumber(nums);
        System.out.println(res);
    }
}
