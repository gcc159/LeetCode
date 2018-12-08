package Array.ConstructBinaryTreeFromPreorderAndPostorder;

public class Solution {
    private int[]inorder;
    private int[]postorder;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        this.inorder=inorder;
        this.postorder=postorder;
        return buildTree(0,inorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int inStart,int inEnd,int postStart,int postEnd){
        TreeNode root=new TreeNode(postorder[postEnd]);
        if(inStart==inEnd){
            root.left=null;
            root.right=null;
            return root;
        }
        int pivot=inStart;
        for(;pivot<inEnd;pivot++) {
            if (inorder[pivot] == postorder[postEnd]) break;
        }
        int leftNum=pivot-inStart;
        int rightNum=inEnd-pivot;

        root.left=leftNum>0?buildTree(inStart,pivot-1,
                postStart,postStart+leftNum-1)
        :null;
        root.right=rightNum>0?
                buildTree(pivot+1,inEnd,postStart+leftNum,postEnd-1):null;
        return root;
    }
}
