package Tree.Path_Sum_II;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null||sum<0) return res;
        if(isLeaf(root)){
            if(sum==0){
                List<Integer> current=new ArrayList<>();
                current.add(root.val);
                res.add(current);
            }
            return res;
        }
        List<List<Integer>> leftResult=pathSum(root.left,sum-root.val);
        List<List<Integer>> rightResult=pathSum(root.right,sum-root.val);
        for(List<Integer> list:leftResult){
            List<Integer> current=new ArrayList<>();
            current.add(root.val);
            current.addAll(list);
            res.add(current);
        }
        for(List<Integer> list:rightResult){
            List<Integer> current=new ArrayList<>();
            current.add(root.val);
            current.addAll(list);
            res.add(current);
        }
        return res;
    }

    private boolean isLeaf(TreeNode root){
        return root.left==root.right;
    }
}
