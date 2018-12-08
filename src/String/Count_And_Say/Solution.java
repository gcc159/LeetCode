package String.Count_And_Say;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String current="11";
        for(int i=2;i<n;i++){
            current=generateNext(current);
        }
        return current;
    }


    private String generateNext(String current){
        List<Integer> numList=new ArrayList<>();
        List<Character> contentList=new ArrayList<>();
       // contentList.add(current.charAt(0));
        int currentSum=1;
        char currentChar=current.charAt(0);
        for(int i=1;i<current.length()-1;i++){
            if(currentChar==current.charAt(i))
                currentSum++;
            else{
                numList.add(currentSum);
                contentList.add(currentChar);
                currentSum=1;
                currentChar=current.charAt(i);
            }
        }
        if(currentChar==current.charAt(current.length()-1)){
            currentSum++;
            numList.add(currentSum);
            contentList.add(currentChar);
        }else{
            numList.add(currentSum);
            contentList.add(currentChar);
            numList.add(1);
            contentList.add(current.charAt(current.length()-1));
        }


        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numList.size();i++){
            sb.append(numList.get(i));
            sb.append(contentList.get(i));
        }
        return sb.toString();
    }



    public static void main(String[] args){
        Solution solution=new Solution();
        solution.countAndSay(4);
    }
}
