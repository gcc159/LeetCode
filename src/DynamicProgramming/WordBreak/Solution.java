package DynamicProgramming.WordBreak;

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character,Set<String>> dic=new HashMap<>();
        for(String word:wordDict){
            Set<String> currentSet=dic.getOrDefault(word.charAt(word.length()-1),new HashSet<>());
            currentSet.add(word);
            dic.put(word.charAt(word.length()-1),currentSet);
        }

        int[] dp=new int[s.length()];
        for(int i=0;i<dp.length;i++){
            Set<String> currerntSet=dic.getOrDefault(s.charAt(i),new HashSet<>());
            dp[i]=0;
            for(String word:currerntSet){
                if(word.length()-1>i)
                    continue;
                else {
                    if(s.indexOf(word,i-word.length()+1)==i-word.length()+1) {
                        if (word.length() - 1 == i)

                            dp[i] += 1;
                        else {
                            dp[i] += dp[i - word.length()];
                        }
                    }
                }
                }

            }
        if(dp[s.length()-1]>0) return true;
        else return false;


    }
}
