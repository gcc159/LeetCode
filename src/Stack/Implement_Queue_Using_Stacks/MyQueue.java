package Stack.Implement_Queue_Using_Stacks;

import java.util.Stack;

class MyQueue {
    Stack<Integer> firstStack=new Stack<>();
    Stack<Integer> secondStack=new Stack<>();

    int current;
    int size;

    /** Initialize your data structure here. */
    public MyQueue() {
        current=0;
        size=0;
    }

    private void change(){
        Stack<Integer> source,target;
        if(current==0){
            source=firstStack;
            target=secondStack;
        }else{
            source=secondStack;
            target=firstStack;
        }
        for(int i=0;i<size;i++){
            int item=source.pop();
            target.push(item);
        }
        current=(++current)%2;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(current!=0)
            change();
        firstStack.push(x);
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(current==0)
            change();

        int res=secondStack.pop();
        size--;

        return res;


    }

    /** Get the front element. */
    public int peek() {
        if(current==0)
            change();

        return secondStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(size>0) return false;
        else return true;
    }
}
