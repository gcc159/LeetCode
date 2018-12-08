package Depth_First_Search.Number_Of_Islands;

import java.util.*;

public class Solution {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        List<Set<Integer>> unionSet=new LinkedList<>();
        Map<Integer,Integer> setIndex=new HashMap<>();
        m=grid.length;
        if(m==0) return 0;
        n=grid[0].length;
        if(n==0) return 0;
        if(grid[0][0]=='1'){
            Set<Integer> set=new TreeSet<>();

            set.add(0);
            unionSet.add(set);
            setIndex.put(0,0);
        }
        for(int j=1;j<grid[0].length;j++){
            if(grid[0][j]=='1'){
                if(grid[0][j-1]=='1'){
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
        for(int i=1;i<grid.length;i++){
            if(grid[i][0]=='1'){
                if(grid[i-1][0]=='1'){
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
        for(int i=1;i<grid.length;i++)
            for(int j=1;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    if(grid[i-1][j]=='1'){
                        int upIndex=setIndex.get(getHash(i-1,j));
                        Set<Integer> upSet=unionSet.get(upIndex);
                        upSet.add(getHash(i,j));

                        if(grid[i][j-1]=='1'){
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
                    }else if(grid[i][j-1]=='1'){
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
        int res=0;
        for(Set<Integer> currentSet:unionSet){
            if(!currentSet.isEmpty()) res++;
        }

        return res;
        
        
    }

    private int getHash(int x,int y){
        return x*n+y;
    }
}
