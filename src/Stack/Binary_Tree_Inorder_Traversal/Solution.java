package Stack.Binary_Tree_Inorder_Traversal;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack=new Stack<>();
        Stack<Integer> stateStack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        nodeStack.push(root);
        stateStack.push(0);
        while(!nodeStack.empty()){
            if(nodeStack.peek()==null){
                 nodeStack.pop();
                 stateStack.pop();
            }
            switch (stateStack.peek()){
                case 0:{
                    stateStack.push(stateStack.pop()+1);
                    nodeStack.push(nodeStack.peek().left);
                    stateStack.push(0);
                }
                break;
                case 1:{
                    res.add(nodeStack.peek().val);
                    TreeNode current=nodeStack.pop();

                    stateStack.peek();
                    nodeStack.push(current.right);
                    stateStack.push(0);
                }
            }
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

}
