package Greedy.Remove_Duplicate_Letters;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder res=new StringBuilder();
        int []times=new int [26];
        int []index=new int[26];
        Arrays.fill(index,Integer.MAX_VALUE);
        for(int i=0;i<s.length();i++){
            times[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            times[s.charAt(i)-'a']--;
            int pos=s.charAt(i)-'a';
            if(index[pos]==Integer.MAX_VALUE){
                index[pos]=i;
            }else{
                boolean isLower=false;
                int min=Integer.MAX_VALUE;
                for(int j=0;j<pos;j++){
                    if(index[j]>index[pos]){
                        isLower=true;
                        min=Math.min(min,index[j]);
                    }
                }
                if(isLower) {
                    for(int j=pos+1;j<26;j++)
                        if(index[j]>=index[pos]&&index[j]<=min&&times[j]==0){
                            isLower=false;
                            break;
                        }
                    if(isLower)
                        index[pos]=i;
                }
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<26;i++)
            if(index[i]<Integer.MAX_VALUE)
                pq.offer(index[i]);
        while(!pq.isEmpty())
            res.append(s.charAt(pq.poll()));
        return res.toString();
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.removeDuplicateLetters(
                "beeaddbeb");
    }
}
