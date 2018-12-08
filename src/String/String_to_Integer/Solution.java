package String.String_to_Integer;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int myAtoi(String str) {
        str=str.trim();

        Set<Character> digitSet=new HashSet<>();
        Set<Character> opSet=new HashSet<>();
        for(int i='0';i<='9';i++)
            digitSet.add((char)i);
        opSet.add('-');
        opSet.add('+');
        if(!digitSet.contains(str.charAt(0))&&!opSet.contains(str.charAt(0)))
            return 0;
        boolean isNegtive=false;
        int startIndex=0;
        if(opSet.contains(str.charAt(0))) {
            if(str.charAt(0) == '-')
                isNegtive = true;
            else
                startIndex++;
        }
        StringBuilder sb=new StringBuilder();
        if(isNegtive) sb.append(str.charAt(startIndex++));
        for(int i=startIndex;i<str.length()&&digitSet.contains(str.charAt(i));i++){
            sb.append(str.charAt(i));
        }

        int digitlength=isNegtive?1:0;
        if(sb.length()<=digitlength) return 0;
        int res=0;
        try{
            res=Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
            res=isNegtive?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        return res;
    }
    class Node{

    }
}
