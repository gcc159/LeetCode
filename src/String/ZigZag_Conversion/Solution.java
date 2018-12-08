package String.ZigZag_Conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if(s.length()<=1||numRows==1) return s;
        int oneProcessNum=numRows*2-2;
        int totalProcess=s.length()/oneProcessNum;
        int remain=s.length()%oneProcessNum;
        List<StringBuilder> allRows=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            allRows.add(new StringBuilder());
        }
        int curIndex=0;
        for(int i=0;i<totalProcess;i++){
            for(int j=0;j<numRows;j++){
                allRows.get(j).append(s.charAt(curIndex++));
            }
            for(int j=numRows-2;j>0;j--){
                allRows.get(j).append(s.charAt(curIndex++));
            }
        }
        if(remain<=numRows){
            for(int j=0;j<remain;j++){
                allRows.get(j).append(s.charAt(curIndex++));
            }
        }else{
            for(int j=0;j<numRows;j++){
                allRows.get(j).append(s.charAt(curIndex++));
            }
            for(int j=numRows-2;curIndex<s.length();j--){
                allRows.get(j).append(s.charAt(curIndex++));
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<numRows;i++){
            res.append(allRows.get(i));
        }
        return res.toString();
    }
}
