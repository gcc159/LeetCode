package Array.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] numsStep={matrix.length,matrix[0].length-1,matrix.length-1,matrix[0].length-2};
        int total=0;
        int direction=0;
        int[][] directionDetail={{0,1},{1,0},{0,-1},{-1,0}};
        int currentX=0;
        int currentY=0;
        List<Integer> res=new ArrayList<>();
        while(total<matrix.length*matrix[0].length){
            for(int i=0;i<numsStep[direction];i++){
                res.add(matrix[currentX][currentY]);
                total++;
                currentX+=directionDetail[direction][0];
                currentY+=directionDetail[direction][1];
            }
            currentX-=directionDetail[direction][0];
            currentY-=directionDetail[direction][1];
            numsStep[direction]-=2;
            direction=(++direction)%4;
            currentX+=directionDetail[direction][0];
            currentY+=directionDetail[direction][1];
        }
        return res;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        int [][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(solution.spiralOrder(matrix));
    }
}
