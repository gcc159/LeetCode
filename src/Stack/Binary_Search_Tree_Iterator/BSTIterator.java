package Stack.Binary_Search_Tree_Iterator;

import java.util.Stack;

public class BSTIterator {

    Stack<Integer> stateStack=new Stack<>();
    Stack<TreeNode> nodeStack=new Stack<>();

    int next;
    public BSTIterator(TreeNode root) {
        if(root!=null) {
            stateStack.push(0);
            nodeStack.push(root);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        boolean res=false;

        while(!nodeStack.empty()){
            switch (stateStack.peek()){
                case 0:{
                    stateStack.push(stateStack.pop()+1);
                    if(nodeStack.peek().left!=null){
                        stateStack.push(0);
                        nodeStack.push(nodeStack.peek().left);
                    }
                }
                break;
                case 1:{
                    next=nodeStack.peek().val;
                    stateStack.push(stateStack.pop()+1);
                    return true;
                }
                case 2:{
                    TreeNode current=nodeStack.pop();

                    stateStack.pop();
                    if(current.right!=null){
                        nodeStack.push(current.right);
                        stateStack.push(0);
                    }
                    break;
                }
            }
        }
        return res;
    }

    /** @return the next smallest number */
    public int next() {
        return next;
    }



    class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
     }
}
