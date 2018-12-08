package Stack.Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack=new Stack<>();
        Stack<Integer> stateStack=new Stack<>();

        List<Integer> res=new ArrayList<>();

        if(root==null) return res;

        nodeStack.push(root);
        stateStack.push(0);

        while (!nodeStack.empty()){
            if(nodeStack.peek()==null){
                nodeStack.pop();
                stateStack.pop();
            }else{
                int state=stateStack.pop();
                switch (state){
                    case 0:{
                        TreeNode left=nodeStack.peek().left;
                        TreeNode right=nodeStack.peek().right;
                        stateStack.push(++state);
                        if(right!=null){
                            nodeStack.push(right);
                            stateStack.push(0);
                        }
                        if(left!=null){
                            nodeStack.push(left);
                            stateStack.push(0);
                        }
                    }
                    break;
                    case 1:{
                        TreeNode current=nodeStack.pop();
                        res.add(current.val);
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
