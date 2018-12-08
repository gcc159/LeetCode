package Stack.Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack=new Stack<>();
        Stack<Integer> stateStack =new Stack<>();


        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        nodeStack.push(root);
        stateStack.push(0);

        while(!nodeStack.empty()){
            if(nodeStack.peek()==null){
                nodeStack.pop();
                stateStack.pop();
            }else{
                int currentState=stateStack.pop();
                switch (currentState) {
                    case 0:{
                        res.add(nodeStack.peek().val);
                        stateStack.push(++currentState);
                        if(nodeStack.peek().left!=null){
                            nodeStack.push(nodeStack.peek().left);
                            stateStack.push(0);
                        }
                    }
                    break;
                    case 1:{
                        TreeNode currentNode=nodeStack.pop();
                        if(currentNode.right!=null){
                            nodeStack.push(currentNode.right);
                            stateStack.push(0);
                        }
                    }
                    break;
                }
            }
        }
        return res;


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
