package Array.Trapping_Rain_Water;

import java.util.*;

public class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        Map<Integer, Integer> map=new TreeMap<>();

        int res=0;
        //int preHeight=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>0){

                int prevHeight=0;
                Iterator<Integer> iterator=map.keySet().iterator();
                int max=Integer.MIN_VALUE;
                while(iterator.hasNext()){

                    int currentHeight=iterator.next();
                    if(currentHeight>height[i]) {
                        max=Math.max(max,map.get(currentHeight));
                        continue;
                    }
                    res+=(i-map.get(currentHeight)-1)*(currentHeight-prevHeight);
                    prevHeight=currentHeight;
                    map.put(currentHeight,i);

                }
                if(max>=0)
                    res+=(i-max-1)*(height[i]-prevHeight);
                map.put(height[i],i);

            }
        }

        return res;
    }




}
