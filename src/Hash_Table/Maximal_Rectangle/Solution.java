package Hash_Table.Maximal_Rectangle;

import java.util.*;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int [][]area=new int[matrix.length][matrix[0].length];


        for(int i=0;i<matrix[0].length;i++){
            area[0][i]=matrix[0][i]=='1'?1:0;
        }

        for(int i=1;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++) {
                area[i][j] =matrix[i][j]-'0';
                if(area[i][j]==1)
                    area[i][j]+=area[i-1][j];
            }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){
                if(area[i][j]>0){
                    int start=j;
                    int end=j;
                    while(start-1>=0&&area[i][start-1]>=area[i][j]) start--;
                    while(end+1<matrix[0].length&&area[i][end+1]>=area[i][j]) end++;
                    int current=area[i][j]*(end-start+1);
                    if(current>max) max=current;
                }
            }
        }
        HashSet<Integer> set=new HashSet<>();
        set.toArray(new Integer[0]);

        return max;
    }
}
