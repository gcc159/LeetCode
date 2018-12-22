package Backtracking.N_Queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String aux;
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n-1;i++)
            sb.append(".");
        aux=sb.toString();
        boolean []hasQueen=new boolean[n];
        boolean[][] left=new boolean[2][];
        left[0]=new boolean[n-1];
        left[1]=new boolean[n];
        boolean[][] right=new boolean[2][];
        right[0]=new boolean[n-1];
        right[1]=new boolean[n];
        List<List<String>> res=new ArrayList<>(backtracking(hasQueen,left,right,0));

        return res;



    }

    private List<List<String>> backtracking(boolean[] hasQueen,boolean[][]leftQueen,boolean rightQueen[][],int currentLevel){
        int n=hasQueen.length;
        List<List<String>> res=new ArrayList<>();

        if(currentLevel==n-1){
            int target=-1;
            for(int i=0;i<n;i++){
                if(!hasQueen[i]){
                    int code=getStatusCode(hasQueen.length-1,i,currentLevel);
                    int leftIndex=-1;
                    int rightIndex=-1;
                    switch (code){
                        case 0: {
                            //left=leftUp;
                            leftIndex=i-currentLevel-1;
                            //right=rightUp;
                            rightIndex=n-1-(currentLevel+i)-1;
                        }
                        break;
                        case 1:{
                            //left=leftDown;
                            leftIndex=currentLevel-i;
                            //right=rightUp;
                            rightIndex=n-1-(currentLevel+i)-1;
                        }
                        break;

                        case 2:{
                            leftIndex=i-currentLevel-1;
                            rightIndex=i+currentLevel-n+1;
                        }
                        break;
                        case 3:{
                            leftIndex=currentLevel-i;
                            rightIndex=i+currentLevel-n+1;
                        }

                    }
                    if(!leftQueen[code/2][leftIndex]&&!rightQueen[code%2][rightIndex]) {
                        target = i;
                        break;
                    }
                }
            }
            if(target>=0){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<target;i++)
                sb.append(".");
            sb.append("Q");
            for(int i=target+1;i<n;i++)
                sb.append(".");
            List<String> current=new ArrayList<>();
            current.add(sb.toString());
            res.add(current);
            }
            return res;
        }else{
            for(int i=0;i<n;i++){
                if(!hasQueen[i]){
                    int code=getStatusCode(hasQueen.length-1,i,currentLevel);
                    int leftIndex=-1;
                    int rightIndex=-1;
                    switch (code){
                        case 0: {
                            //left=leftUp;
                            leftIndex=i-currentLevel-1;
                            //right=rightUp;
                            rightIndex=n-1-(currentLevel+i)-1;
                        }
                        break;
                        case 1:{
                            //left=leftDown;
                            leftIndex=currentLevel-i;
                            //right=rightUp;
                            rightIndex=n-1-(currentLevel+i)-1;
                        }
                        break;

                        case 2:{
                            leftIndex=i-currentLevel-1;
                            rightIndex=i+currentLevel-n+1;
                        }
                        break;
                        case 3:{
                            leftIndex=currentLevel-i;
                            rightIndex=i+currentLevel-n+1;
                        }

                    }
                    if(!leftQueen[code%2][leftIndex]&&!rightQueen[code/2][rightIndex]) {

                        hasQueen[i] = true;
                        leftQueen[code%2][leftIndex]=true;

                        rightQueen[code/2][rightIndex]=true;
                        List<List<String>> nextRes = backtracking(hasQueen,leftQueen,rightQueen, currentLevel + 1);
                        if (nextRes.size() > 0) {
                            StringBuilder sb = new StringBuilder(aux);
                            sb.insert(i, 'Q');
                            for (List<String> next : nextRes) {
                                next.add(0, sb.toString());
                            }
                            res.addAll(nextRes);
                        }
                        hasQueen[i] = false;
                        leftQueen[code%2][leftIndex]=false;

                        rightQueen[code/2][rightIndex]=false;
                    }
                }
            }
            return res;
        }
    }

    private int getStatusCode(int n,int x,int y){
        int res=0;

        res+=x+y>=n?1:0;
        res<<=1;
        res+=y>=x?1:0;
        return res;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.solveNQueens(4);
    }
}
