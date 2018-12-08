package Backtracking.Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        return backtracking(new ArrayList<String>(),s);
    }

    private List<List<String>> backtracking(List<String> previous,String currentStr){
        List<List<String>> res=new ArrayList<>();
        if(currentStr.length()==0)
            res.add(new ArrayList<String>(previous));
        else
        for(int endIndex=1;endIndex<=currentStr.length();endIndex++){
            String currentSubstr=currentStr.substring(0,endIndex);
            if(isPalindrome(currentSubstr)){
                previous.add(currentSubstr);
                res.addAll(backtracking(previous,currentStr.substring(endIndex)));
                previous.remove(previous.size()-1);
            }
        }
        return res;
    }
    private boolean isPalindrome(String string){
        StringBuilder sb=new StringBuilder(string);
        String reverse=sb.reverse().toString();;
        return string.equals(reverse);
    }
}
