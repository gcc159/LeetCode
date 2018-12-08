package Math.Fraction_to_Recurring_Decimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        boolean isNeg=false;
        long lNumerator=numerator;
        if((lNumerator>0&&denominator<0)||((lNumerator<0)&&(denominator>0))) {
            isNeg = true;
            lNumerator = Math.abs(lNumerator);
            denominator = Math.abs(denominator);
        }
        List<Integer> resList=new ArrayList<>();
        Map<Long,Integer> map=new HashMap<>();
        int pos=0;
        boolean isRur=false;
        int startPos=-1;
        int endPos=-1;
        while(lNumerator!=0){
            if(!map.keySet().contains(lNumerator)) {
                long current = lNumerator / denominator;
                map.put(lNumerator,pos);
                resList.add((int) current);
                lNumerator=(lNumerator%denominator)*10;
                pos++;
            }else{
                isRur=true;
                startPos=map.get(lNumerator);
                endPos=pos-1;
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        if(isNeg) sb.append('-');
        if(isRur){
            sb.append(resList.get(0));
            sb.append(".");
            for(int i=1;i<=endPos;i++) {
                if (i == startPos)
                    sb.append('(');
                sb.append(resList.get(i));
            }
            sb.append(')');
        }else{
            sb.append(resList.get(0));
            if(resList.size()>1){
                sb.append(".");
                for(int i=1;i<resList.size();i++)
                    sb.append(resList.get(i));
            }
        }
        if(!isNeg&&sb.toString().charAt(0)=='-')
            sb.deleteCharAt(0);
        return sb.toString();
    }


    public static void main(String[] args){
        Solution solution=new Solution();
        solution.fractionToDecimal(-2147483648,
                -1);

    }
}
