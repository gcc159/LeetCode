package DynamicProgramming.Triangle;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int []previous=new int[triangle.size()];
        int []current=new int[triangle.size()];
        Arrays.fill(previous,Integer.MAX_VALUE);
        Arrays.fill(current,Integer.MAX_VALUE);
        previous[0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            List<Integer> currentList=triangle.get(i);
            current[0]=previous[0]+currentList.get(0);
            for(int j=1;j<currentList.size()-1;j++){
                current[j]=Math.min(previous[j-1],previous[j])+currentList.get(j);
            }
            current[currentList.size()-1]=previous[currentList.size()-2]+currentList.get(currentList.size()-1);

            System.arraycopy(current,0,previous,0,triangle.size());

        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();i++)
            if(previous[i]<min)
                min=previous[i];
        return min;
    }
}
