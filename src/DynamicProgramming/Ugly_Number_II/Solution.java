package DynamicProgramming.Ugly_Number_II;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] res=new int[n];
        res[0]=1;
        int index2,index3,index5;
        index2=index3=index5=0;

        int counter=1;

        while(counter<n){
            res[counter]=Math.min(res[index2]*2,Math.min(res[index3]*3,res[index5]*5));

            if(res[counter]==res[index2]*2) index2++;
            if(res[counter]==res[index3]*3) index3++;
            if(res[counter]==res[index5]*5) index5++;

            counter++;
        }

        return res[n-1];




    }
}
