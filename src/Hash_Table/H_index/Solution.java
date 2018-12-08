package Hash_Table.H_index;

import java.util.*;

public class Solution {
        public int hIndex(int[] citations) {
            if(citations.length==0) return 0;
            Map<Integer,Integer> map=new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for(int i=0;i<citations.length;i++)
                map.put(citations[i],map.getOrDefault(citations[i],0)+1);

            Iterator<Integer> iterator=map.keySet().iterator();
            int sum=0;
            int previous=-1;
            while(iterator.hasNext()){
                int current=iterator.next();
                if(sum<=previous&&sum>=current) return sum;
                sum+=map.get(current);
                if(sum>=current) {
                    if(sum>=current) {
                        return Math.min(sum,current);
                    }
                }
                previous = current;

            }
            return Math.min(sum,previous);

    }
}
