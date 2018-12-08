package Breadth_First_Search.Word_Ladder;

import java.util.*;

public class Solution {
    private int min;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        boolean hasEnd=false;
        for(int i=0;i<wordList.size();i++)
        {
            if(wordList.get(i).equals(endWord)) {
                hasEnd = true;
                break;
            }
        }
        if(!hasEnd) return 0;
        HashSet<String> visited = new HashSet<String>();
        //将起始字符串和目标字符串加入开始集和到达集
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }

        return 0;

    }



    public static void main(String []args){
        String []total={"hot","dog"};
        List<String> totalList= Arrays.asList(total);
        Solution solution=new Solution();
        solution.ladderLength("hot","dog",totalList);

    }
}
