package Tree.Flatten_Binary_Tree_toLinkedList;

import Util.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        if(root==null||isLeaf(root)) return;
        if(root.left==null) {
            flatten(root.right,root);
            return ;
        }
        if(root.right==null) {
            flatten(root.left,root);
            return;
        }
        TreeNode rightNode=root.right;
        TreeNode last=flatten(root.left,root);

        last=flatten(rightNode,last);
        last.left=last.right=null;
    }

    private TreeNode flatten(TreeNode node,TreeNode upperNode){
        if(node==null) return null;
        if(isLeaf(node)){
            upperNode.right=node;
            upperNode.left=null;
            return node;
        }
        TreeNode rightNode=node.right;
        upperNode.right=node;
        upperNode.left=null;
        if(node.left==null) return flatten(node.right,node);
        if(node.right==null) return flatten(node.left,node);
        TreeNode lastNode=flatten(node.left,node);
        lastNode = flatten(rightNode,lastNode);
        return lastNode;

    }

    private boolean isLeaf(TreeNode node){
        return node.left==node.right;
    }
}
