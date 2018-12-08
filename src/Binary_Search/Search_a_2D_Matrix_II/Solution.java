package Binary_Search.Search_a_2D_Matrix_II;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart=0;
        while(rowStart<matrix.length){
            if(matrix[rowStart][matrix[0].length]>=target )
                break;
            rowStart++;
        }
        if(rowStart==matrix.length) return false;
        int rowEnd=matrix.length-1;
        while(rowEnd>=0){
            if(matrix[rowEnd][0]<=target)
                break;
            rowEnd--;
        }
        if(rowEnd<0) return false;
        int colStart=0;

        while(colStart<matrix[0].length){
            if(matrix[rowEnd][colStart]>=target)
                break;
            colStart++;
        }
        if(colStart==matrix[0].length) return false;

        int colEnd=matrix[0].length-1;
        while(colEnd>=0){
            if(matrix[rowStart][colEnd]<=target)
                break;
            colEnd--;
        }
        if(colEnd<0) return false;
        for(int i=rowStart;i<=rowEnd;i++)
            for(int j=colStart;j<=colEnd;j++){
                if(matrix[i][j]==target)
                    return true;
            }
        return false;
    }


}
