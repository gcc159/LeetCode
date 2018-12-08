package Stack.Implement_Stack_Using_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> firstQueue=new LinkedList<>();

    Queue<Integer> secondQueue=new LinkedList<>();

    int current=0;
    int size=0;
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(current==0)
            firstQueue.offer(x);
        else
            secondQueue.offer(x);
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> source,target;
        if(current==0){
            source=firstQueue;
            target=secondQueue;
        }else{
            source=secondQueue;
            target=firstQueue;
        }
        for(int i=0;i<size-1;i++){
            int item=source.poll();
            target.offer(item);
        }
        size--;
        current=(current+1)%2;
        return source.poll();


    }

    /** Get the top element. */
    public int top() {
        int target=pop();

        push(target);
        return target;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(size>0) return false;
        else return true;
    }
}
