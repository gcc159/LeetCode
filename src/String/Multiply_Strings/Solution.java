package String.Multiply_Strings;

import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {
        char[] first=num1.toCharArray();
        char[] second=num2.toCharArray();

        int []res=new int[num1.length()+num2.length()+1];
        int []current=new int[num1.length()+1];
        int startPosition=0;
        int currentLength=0;
        for(int i=second.length-1;i>=0;i--){
            Arrays.fill(current,0);
            for(int j=first.length-1;j>=0;j--){
                int currentNum=(second[i]-'0')*(first[j]-'0');

                current[first.length-j]+=currentNum /10;
                current[first.length-1-j]+=currentNum%10;
            }
            currentLength=first.length;
            if(current[first.length]>0) currentLength++;
            for(int j=0;j<currentLength;j++){
                res[startPosition+j]+=current[j];
            }

            startPosition++;
        }

        for(int i=0;i<res.length-1;i++){
            res[i+1]+=res[i]/10;
            res[i]%=10;
        }
        startPosition=res.length-1;
        while(res[startPosition]==0) startPosition--;
        StringBuilder sb=new StringBuilder();
        for(int i=startPosition;i>=0;i--)
            sb.append(res[i]);
        return sb.toString();
    }
}
