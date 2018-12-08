package Binary_Search.Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length==0) return 0;
        int res=0;
        for(int i=0;i<matrix.length;i++){
            int []array=new int[matrix[0].length];

            for(int j=i;j>=0;j--){
                TreeSet<Integer> set=new TreeSet<>();
                int val=0;
                for(int l=0;l<matrix[0].length;l++){
                    array[l]+=matrix[j][l];
                    val+=array[l];
                    Integer another=set.ceiling(val-k);
                    if(another!=null){
                        res=Math.max(res,val-another);
                    }
                    set.add(val);
                }
            }
        }

        return res;
    }


}
