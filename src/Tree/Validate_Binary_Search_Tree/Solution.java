package Tree.Validate_Binary_Search_Tree;

import Util.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return isValidBSTtracking(root).isValid;
    }

    private Result isValidBSTtracking(TreeNode node) {
        if(node==null) return new Result(null,null,true);
        if(node.left==null&&node.right==null) return new Result(node.val,node.val,true);
        Result leftResult=isValidBSTtracking(node.left);
        Result rightResult=isValidBSTtracking(node.right);
        if(!leftResult.isValid||!rightResult.isValid) return new Result(-1,-1,false);

        if((leftResult.max!=null&&leftResult.max>=node.val)||(rightResult.min!=null&&rightResult.min<=node.val)) return new Result(-1,-1,false);
        return new Result(leftResult.min!=null?Math.min(leftResult.min,node.val):node.val,rightResult.max!=null?Math.max(rightResult.max,node.val):node.val,true);

    }
    class Result{
        Integer min;
        Integer max;
        boolean isValid;

        private Result(Integer min, Integer max, boolean isValid) {
            this.min = min;
            this.max = max;
            this.isValid = isValid;
        }
    }
}
