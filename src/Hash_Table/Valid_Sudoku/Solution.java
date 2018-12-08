package Hash_Table.Valid_Sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> colSet=new HashSet<>();
        Set<Character> rowSet=new HashSet<>();
        for(int i=0;i<9;i++){
            colSet.clear();
            rowSet.clear();
            for(int j=0;j<9;j++){
                if(board[i][j]>='1'&&board[i][j]<='9'){
                    if(colSet.contains(board[i][j])) return false;
                    else colSet.add(board[i][j]);
                }else if(board[i][j]!='.') return false;

                if(board[j][i]>='1'&&board[j][i]<='9'){
                    if(rowSet.contains(board[j][i])) return false;
                    else rowSet.add(board[j][i]);
                }else if(board[j][i]!='.') return false;
            }
        }

        int[][] startPos={{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        colSet.clear();
        for(int start=0;start<9;start++){
            colSet.clear();

            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++) {
                    int x = startPos[start][0] + i;
                    int y= startPos[start][1]+j;
                    if (board[x][y] >= '1' && board[x][y] <= '9') {
                        if (colSet.contains(board[x][y])) return false;
                        else colSet.add(board[x][y]);
                    } else if (board[x][y] != '.') return false;
                }

        }
        return true;
    }
}
