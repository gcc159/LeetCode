package Array.ConstructBinaryTreeFromPreorderandInorderTraversal;

import java.util.Arrays;

public class Solution {
    private int[]preorder;
    private int[]inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return buildTree(0,preorder.length-1,0,preorder.length-1);
    }
    public TreeNode buildTree(int preStart,int preEnd,int inStart,int inEnd){
        TreeNode root=new TreeNode(preorder[preStart]);
        if(preStart==preEnd){
            root.left=null;
            root.right=null;
            return root;
        }
        int pivot=inStart;
        for(;pivot<inEnd;pivot++) {
            if (inorder[pivot] == preorder[preStart]) break;
        }
        int leftNum=pivot-inStart;
        int rightNum=inEnd-pivot;

        root.left=leftNum>0?buildTree(preStart+1,
                preStart+leftNum,inStart,pivot-1
        ):null;
        root.right=rightNum>0?
                buildTree(preStart+leftNum+1,
                        preEnd,pivot+1,inEnd):null;
        return root;
    }
    class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public static void main(String[] args){
        int[] pre={3,9,20,15,7};

        int[] in={9,3,15,20,7};

        Solution solution=new Solution();
        solution.buildTree(pre,in);
  }
}
