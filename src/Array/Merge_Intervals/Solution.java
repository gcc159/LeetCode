package Array.Merge_Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<endWithIndex> endWithIndices=new ArrayList<>();
        List<Interval> res=new ArrayList<>();
        if(intervals.size()==0) return res;
        for(int i=0;i<intervals.size();i++){
            endWithIndices.add(new endWithIndex(intervals.get(i).end,i));
        }
        Collections.sort(endWithIndices);
        Interval previous=intervals.get(endWithIndices.get(0).getIndex());
        for(int i=1;i<intervals.size();i++){
            int currentIndex=endWithIndices.get(i).getIndex();
            int currentStart=intervals.get(currentIndex).start;
            int currentEnd=intervals.get(currentIndex).end;
            if(currentStart<=previous.end&&currentEnd>=previous.end){
                previous.start = Math.min(previous.start,currentStart);
                previous.end = currentEnd;
            }else{
                res.add(previous);
                previous=intervals.get(currentIndex);
            }
        }
        res.add(previous);
        return res;
    }

    private class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    private class endWithIndex implements Comparable<endWithIndex>{
        Integer end;
        int index;

        public Integer getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public endWithIndex(int end, int index) {
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(endWithIndex o) {
            return this.getEnd().compareTo(o.getEnd());
        }
    }
}
