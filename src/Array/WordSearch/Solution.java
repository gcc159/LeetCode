package Array.WordSearch;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public boolean exist(char[][] board, String word) {
        Stack<Pair> stack=new Stack<>();
        Stack<Integer> currentStatus=new Stack<>();
        List<Pair> startPosition=new ArrayList<>();
        char first=word.charAt(0);
        int[][] orient={{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==first)
                    startPosition.add(new Pair(i,j));
            }
        for(int i=0;i<startPosition.size();i++){
            stack.push(startPosition.get(i));
            currentStatus.push(0);
            int currentIndex=0;
            //Pair previous=new Pair(-1,-1);
            Set<Pair> allPrevious=new HashSet<>();
            //allPrevious.add(previous);
            while(!stack.empty()){
                int status=currentStatus.peek();
                int newRow=stack.peek().getRow()+orient[status][0];
                int newCol=stack.peek().getCol()+orient[status][1];
                Pair newPair=new Pair(newRow,newCol);
                if((newRow>=0&&newRow<board.length)
                        &&(newCol>=0&&newCol<board[0].length)&&
                        (!allPrevious.contains(newPair))
                        &&board[newRow][newCol]==word.charAt(currentIndex+1)){
                    if(currentIndex==word.length()-2) return true;
                    //currentStatus.push(status);
                    allPrevious.add(stack.peek());
                    stack.push(newPair);
                    currentStatus.push(0);
                    currentIndex++;
                }else{
                    status++;
                    if(status>3){
                    while(status>3) {
                        stack.pop();
                        if(stack.empty()) break;
                        allPrevious.remove(stack.peek());
                        currentStatus.pop();
                        currentIndex--;
                        status = currentStatus.pop();

                        currentStatus.push(++status);
                    }

                    }else{
                        currentStatus.pop();
                        currentStatus.push(status);
                    }
                }
            }
        }
        return false;
    }
    class Pair{
        private int row;
        private int col;

        private Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if(this.col==((Pair)obj).getCol()&&
                    this.row==((Pair)obj).getRow())
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return new Integer(this.row).hashCode()+new Integer(this.col).hashCode();
        }
    }

    public static void main(String[] args){
        char[][] borad={{'a','a'}};
        String word="a";
        Solution solution=new Solution();
        System.out.println(solution.exist(borad,word));

    }

}
