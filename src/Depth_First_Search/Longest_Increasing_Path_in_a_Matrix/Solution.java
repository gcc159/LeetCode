package Depth_First_Search.Longest_Increasing_Path_in_a_Matrix;

public class Solution {

    int res=Integer.MIN_VALUE;
    int [][]direction={{-1,0},{1,0},{0,1},{0,-1}};
    int [][] currentMax;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return 0;
        currentMax=new int[matrix.length][matrix[0].length];
        boolean[][] visited=new boolean [matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                currentMax[i][j]=1;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                visited[i][j]=true;
                dfs(i,j,visited,1,matrix);
                visited[i][j]=false;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res=Math.max(res,currentMax[i][j]);
            }
        }
        return res;
    }

    private void dfs(int x,int y ,boolean[][] visited,int num,int[][]matrix){
        currentMax[x][y]=Math.max(num,currentMax[x][y]);
        for(int i=0;i<4;i++){
            int nextX=x+direction[i][0];
            int nextY=y+direction[i][1];
            if(nextX>=0&&nextX<visited.length&&nextY>=0&&nextY<visited[0].length)
                if(matrix[nextX][nextY]>matrix[x][y]&&!visited[nextX][nextY]&&num+1>currentMax[nextX][nextY]){
                    visited[nextX][nextY]=true;
                    dfs(nextX,nextY,visited,num+1,matrix);
                    visited[nextX][nextY]=false;
                }
        }
    }
}
