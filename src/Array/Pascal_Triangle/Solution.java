package Array.Pascal_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows==0) return res;
        List<Integer> first=new ArrayList<>();
        first.add(1);
        res.add(first);

        if(numRows==1) return res;
        for(int i=1;i<numRows;i++){
            List<Integer> last=res.get(i-1);
            List<Integer> current= new ArrayList<>();
            current.add(1);
            for(int j=1;j<i;j++){
                int sum=last.get(j-1)+last.get(j);
                current.add(sum);
            }
            current.add(1);
            res.add(current);
        }
        return res;

    }
    public List<Integer> getRow(int rowIndex) {
        int[][] res=new int[2][rowIndex+1];
        res[0][0]=1;
        List<Integer> result=new ArrayList<>();
        int currentIndex=1;
        if(rowIndex==0) {
            result.add(1);
            return result;
        }
        for(int i=1;i<=rowIndex;i++){
            res[currentIndex][0]=1;
            for(int j=1;j<i;j++)
                res[currentIndex][j]=res[1-currentIndex][j-1]+res[1-currentIndex][j];
            res[currentIndex][i]=1;
            currentIndex=(++currentIndex)%2;
        }

        for(int i=0;i<rowIndex;i++){
            result.add(res[1-currentIndex][i]);
        }
        return result;


    }
}
