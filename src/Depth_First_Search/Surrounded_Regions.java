package Depth_First_Search;

import Array.Partition_Labels.Solution;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Surrounded_Regions {
    private int m;
    private int n;
    public void solve(char[][] board) {
        List<Set<Integer>> unionSet=new LinkedList<>();
        Map<Integer,Integer> setIndex=new HashMap<>();
        m=board.length;
        n=board[0].length;
        if(m==0||n==0) return;
        if(board[0][0]=='O'){
            Set<Integer> set=new TreeSet<>();

            set.add(0);
            unionSet.add(set);
            setIndex.put(0,0);
        }
        for(int j=1;j<board[0].length;j++){
            if(board[0][j]=='O'){
                if(board[0][j-1]=='O'){
                    int index=setIndex.get(getHash(0,j-1));
                    unionSet.get(index).add(getHash(0,j));
                    setIndex.put(getHash(0,j),index);
                }
                else{
                    Set<Integer> set=new TreeSet<>();
                    set.add(getHash(0,j));
                    unionSet.add(set);
                    setIndex.put(getHash(0,j),unionSet.size()-1);
                }
            }
        }
        for(int i=1;i<board.length;i++){
            if(board[i][0]=='O'){
                if(board[i-1][0]=='O'){
                    int index=setIndex.get(getHash(i-1,0));
                    unionSet.get(index).add(getHash(i,0));
                    setIndex.put(getHash(i,0),index);
                }
                else{
                    Set<Integer> set=new TreeSet<>();
                    set.add(getHash(i,0));
                    unionSet.add(set);
                    setIndex.put(getHash(i,0),unionSet.size()-1);
                }
            }
        }


        for(int i=1;i<board.length;i++)
            for(int j=1;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    if(board[i-1][j]=='O'){
                        int upIndex=setIndex.get(getHash(i-1,j));
                        Set<Integer> upSet=unionSet.get(upIndex);
                        upSet.add(getHash(i,j));

                        if(board[i][j-1]=='O'){
                            int leftIndex=setIndex.get(getHash(i,j-1));
                            if(leftIndex!=upIndex){
                                Set<Integer> leftSet=unionSet.get(leftIndex);
                                upSet.addAll(leftSet);
                                for(Integer position:leftSet){
                                    setIndex.put(position,upIndex);
                                }
                                leftSet.clear();
                                //unionSet.remove(leftIndex);
                            }
                        }
                        setIndex.put(getHash(i,j),upIndex);
                    }else if(board[i][j-1]=='O'){
                        int leftIndex=setIndex.get(getHash(i,j-1));
                        Set<Integer> leftSet=unionSet.get(leftIndex);
                        leftSet.add(getHash(i,j));
                        setIndex.put(getHash(i,j),leftIndex);
                    }else{
                        Set<Integer> newSet=new TreeSet<>();
                        newSet.add(getHash(i,j));
                        unionSet.add(newSet);
                        setIndex.put(getHash(i,j),unionSet.size()-1);
                    }
                }
            }
        for(Set<Integer> currentSet:unionSet){
            boolean isSurround=true;
            for(Integer integer:currentSet){
                int y=integer%n;
                int x=(integer-y)/n;
                if((x==0||x==board.length-1)||(y==0||y==board[0].length-1)){
                    isSurround=false;
                    break;
                }
            }
            if(isSurround){
                for(Integer integer:currentSet){
                    int y=integer%n;
                    int x=(integer-y)/n;
                    board[x][y]='X';
                }
            }
        }

    }

    private int getHash(int x,int y){
        return x*n+y;
    }

    public static void main(String[] args){
        Surrounded_Regions solution=new Surrounded_Regions();
        char [][]board={{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        solution.solve(board);
        System.out.println("1");
    }

    /*class Position implements Comparable<Position>{
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x==((Position)obj).x&&this.y==((Position)obj).y;
        }

        @Override
        public int compareTo(Position o) {
            if(this.x==o.x)
                return Integer.compare(this.y,o.y);
            else

                return Integer.compare(this.x,o.x);
        }
    }*/
}
