package Array.Rotate_Image;

class Solution {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        if(len>1){
            rotate_detail(matrix,0,0,len);
        }
    }

    public void rotate_detail(int[][] matrix,int firstRow,int firstCol,int size){
        if(size<=1) return;
        int temp;
        temp=matrix[firstRow][firstCol+size-1];

        matrix[firstRow][firstCol+size-1]=matrix[firstRow][firstCol];
        matrix[firstRow][firstCol]=matrix[firstRow+size-1][firstCol];
        matrix[firstRow+size-1][firstCol]=matrix[firstRow+size-1][firstCol+size-1];
        matrix[firstRow+size-1][firstCol+size-1]=temp;

        for(int i=1;i<size-1;i++){
            int swap=matrix[firstRow][firstCol+i];
            matrix[firstRow][firstCol+i]=matrix[firstRow+size-1-i][firstCol];
            matrix[firstRow+size-1-i][firstCol]=matrix[firstRow+size-1][firstCol+size-1-i];
            matrix[firstRow+size-1][firstCol+size-1-i]=matrix[firstRow + i][firstCol+size-1];
            matrix[firstRow + i][firstCol+size-1]=swap;

        }

        rotate_detail(matrix,firstRow+1,firstCol+1,size-2);


    }

}