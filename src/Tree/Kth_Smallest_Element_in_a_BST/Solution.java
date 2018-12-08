package Tree.Kth_Smallest_Element_in_a_BST;

import Util.TreeNode;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> node=new Stack<>();
        while(root!=null){
            node.push(root);
            root=root.left;
        }
        int current=0;
        TreeNode currentNode=null;
        while(current<k){
            currentNode=node.pop();
            current++;
            if(current==k) break;

            if(currentNode.right!=null){
                currentNode=currentNode.right;
                while(currentNode!=null) {
                    node.push(currentNode);

                    currentNode = currentNode.left;
                }
            }
        }
        return currentNode.val;
    }
}
