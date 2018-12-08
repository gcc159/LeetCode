package Backtracking.Letter_Combinations_of_a_Phone_Number;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private char[][] digitsToLetter={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'}
    ,{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        return backtracking(digits,new StringBuilder());
    }

    private List<String> backtracking(String currentDigits, StringBuilder currentLetter){
        List<String> res=new LinkedList<>();
        if(currentDigits.length()==0){
            res.add(currentLetter.toString());
            return res;
        }else{
            for(int i=0;i<digitsToLetter[currentDigits.charAt(0)-'2'].length;i++){
                StringBuilder next=currentLetter.append(digitsToLetter[currentDigits.charAt(0)-'2'][i]);
                res.addAll(backtracking(currentDigits.substring(1),next));
                currentLetter.deleteCharAt(currentLetter.length()-1);
            }
            return res;
        }

    }

    public static void main(String[] args){
        String digits="23";
        Solution solution=new Solution();
        solution.letterCombinations(digits);

    }
}
