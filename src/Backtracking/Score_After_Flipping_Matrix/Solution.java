package Backtracking.Score_After_Flipping_Matrix;

public class Solution {
    public int matrixScore(int[][] A) {
        while(true){
            int targetRow=-1;
            int targetCol=-1;
            for(int i=0;i<A[0].length;i++){
                int res=0;
                for(int j=0;j<A.length;j++)
                    res+=A[j][i];
                if(2*res<A.length){
                    targetCol=i;
                    break;
                }
            }
            if(targetCol>=0){
                for(int j=0;j<A.length;j++)
                    A[j][targetCol]=1-A[j][targetCol];
                continue;
            }
            for(int i=0;i<A.length;i++){
                int res=0;

                if(A[i][0]==0){
                    targetRow=i;
                    break;
                }
            }
            if(targetRow>=0){
                for(int j=0;j<A[0].length;j++)
                    A[targetRow][j]=1-A[targetRow][j];
                continue;
            }

            break;
        }
        int res=0;
        for(int i=0;i<A.length;i++){
            int current=0;
            int positive=0;
            for(int j=0;j<A[0].length;j++){
                current<<=1;
                current+=A[i][j];
            }
            res+=current;
        }
        return res;

    }


    public static void main(String[] args){
        Solution solution=new Solution();
        int [][]A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        solution.matrixScore(A);
    }
}
