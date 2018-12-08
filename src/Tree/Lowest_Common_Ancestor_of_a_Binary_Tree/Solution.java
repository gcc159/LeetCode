package Tree.Lowest_Common_Ancestor_of_a_Binary_Tree;

import Util.TreeNode;

import java.util.Stack;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while((root.left==null||root.right==null)&&(root!=p)&&root!=q){
            if(root.left==null) root=root.right;
            else root=root.left;
        }
        if(root==p||root==q) return root;
        Stack<TreeNode> first=find(root,p);
        Stack<TreeNode> second=find(root,q);
        TreeNode previous=null;
        while(first.peek()==second.peek()&&(!first.isEmpty())&&(!second.isEmpty())){
            previous=first.pop();
            second.pop();
        }
        return previous;
    }

    Stack<TreeNode> find(TreeNode current,TreeNode target){
        Stack<TreeNode> res=new Stack<>();

        if(current==null) return res;
        if(current==target){
            res.push(current);
            return res;
        }
        Stack<TreeNode> leftResult=find(current.left,target);
        if(!leftResult.isEmpty()){
            res.addAll(leftResult);
            res.push(current);
            return res;
        }
        Stack<TreeNode> rightResult=find(current.right,target);
        if(!rightResult.isEmpty()){
            res.addAll(rightResult);
            res.push(current);
            return res;
        }
        return res;


    }

}
