package Array.Queue_Reconstruction_by_Height;


import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Solution {
    private class Point implements Comparable<Point>{
        int height;
        int index;

        @Override
        public int compareTo(Point o) {
            if(this.height!=o.height)
                return Integer.compare(this.height,o.height);
            else{
                return Integer.compare(this.index,o.index);
            }
        }

        public Point(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
    public int[][] reconstructQueue(int[][] people) {

        int[] lessAhead=new int[people.length];
        PriorityQueue<Point> pq=new PriorityQueue<>(people.length);

        List<Integer> indexs=new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return Integer.compare(o1[1],o2[1]);
                }else
                    return Integer.compare(o1[0],o2[0]);
            }
        });
        for(int i=0;i<people.length;i++){
            lessAhead[i]=people[i][1];
            if(lessAhead[i]==0)
                pq.offer(new Point(people[i][0],i));
        }
        while(!pq.isEmpty()){
            Point current=pq.poll();
            indexs.add(current.index);
            for(int i=current.index+1;i<people.length;i++){
                if(lessAhead[i]>0&&people[i][0]<=current.height){
                    lessAhead[i]--;
                    if(lessAhead[i]==0)
                        pq.offer(new Point(people[i][0],i));
                }
            }
        }
        int [][]res=new int[people.length][2];
        for(int i=0;i<indexs.size();i++){
            res[i]=people[indexs
                    .get(i)];
        }
        return res;

    }

    public static void main(String []args){
        int[][] nums={{7,0},{4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution solution=new Solution();
        solution.reconstructQueue(nums);
    }

}
