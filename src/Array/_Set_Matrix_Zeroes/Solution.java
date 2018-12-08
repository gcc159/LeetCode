package Array._Set_Matrix_Zeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            Boolean isTurnZeros = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    isTurnZeros=true;
                    for(int k=0;k<matrix.length;k++)
                        if(matrix[k][j]!=0)
                            matrix[i][j]=Integer.MAX_VALUE;
                }
            }
            if(isTurnZeros)
                for(int k=0;k<matrix[0].length;k++)
                    matrix[i][k]=0;
        }
        for(int i=0;i<matrix.length;i++)
            for (int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j]==Integer.MAX_VALUE) matrix[i][j]++;
    }
}
