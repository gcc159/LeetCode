package Stack.Min_Stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    int count;
    int minElement;
    List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        count=0;
        minElement=Integer.MAX_VALUE;

        list=new ArrayList<>();
    }

    public void push(int x) {
        list.add(count++,x);
        if(x<minElement) minElement=x;
    }

    public void pop() {
        if(list.get(count-1)==minElement){
            minElement=Integer.MAX_VALUE;
            for(int i=0;i<count-1;i++)
                if(minElement>list.get(i))
                    minElement=list.get(i);
        }

        count--;
    }

    public int top() {
        return list.get(count-1);
    }

    public int getMin() {
        return minElement;
    }
}
