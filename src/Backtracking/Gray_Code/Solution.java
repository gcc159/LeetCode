package Backtracking.Gray_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        int total=(int)Math.pow(2,n);
        int []res=new int[total];
        int []current=new int[n];
        boolean []modified=new boolean[n];
        int k=1;
        res[0]=0;
        while(k<total){
            int currentIndex=n-1;
            for(int i=n-1;i>=0;i--){
                if(!modified[i]){
                    currentIndex=i;
                    break;
                }
            }
            current[currentIndex]=(current[currentIndex]+1)%2;
            modified[currentIndex]=true;
            for(int i=currentIndex+1;i<n;i++)
                modified[i]=false;
            res[getValue(current)]=k++;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++)
            result.add(res[i]);
        return result;
    }

    private int getValue(int[] current){
        int res=0;
        int pow=1;
        for(int i=current.length-1;i>=0;i--){
            res+=current[i]*pow;
            pow*=2;
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.grayCode(2);
    }
}
