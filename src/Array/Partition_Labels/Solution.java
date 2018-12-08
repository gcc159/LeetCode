package Array.Partition_Labels;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        Index []indices=new Index[26];
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<26;i++)
            indices[i]=new Index(-1,-1);
        for(int i=0;i<S.length();i++){
            int index=S.charAt(i)-'a';
            if(indices[index].start==-1)
                indices[index]=new Index(i,i);
            else indices[index].end=i;
        }
        Arrays.sort(indices);
        int currentStart=indices[25].start;
        int currentEnd=indices[25].end;
        for(int i=24;indices[i].start>=0;i--){
            if(indices[i].end>=currentStart)
                currentStart=Math.min(currentStart,indices[i].start);
            else{
                res.add(currentEnd-currentStart+1);
                currentStart=indices[i].start;
                currentEnd=indices[i].end;
            }
        }
        res.add(currentEnd-currentStart+1);
        Collections.reverse(res);
        return res;
    }

    class Index implements Comparable<Index>{
        public int start;
        public int end;

        public Index() {
            this.start=this.end=-1;
        }

        public Index(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(@NotNull Solution.Index o) {
            if(Integer.compare(end,o.end)==0)
                return Integer.compare(start,o.start);
            else return Integer.compare(end,o.end);
        }
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");
    }
}
