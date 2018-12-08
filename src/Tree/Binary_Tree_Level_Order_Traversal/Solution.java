package Tree.Binary_Tree_Level_Order_Traversal;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> nodeQueue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        int currentSize=1;
        int nextSize=0;
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            List<Integer> currentResult=new ArrayList<>();
            for(int i=0;i<currentSize;i++){
                TreeNode node=nodeQueue.poll();
                currentResult.add(node.val);
                if(node.left!=null){
                    nodeQueue.offer(node.left);
                    nextSize++;
                }
                if(node.right!=null){
                    nodeQueue.offer(node.right);
                    nextSize++;
                }
            }
            res.add(currentResult);
            currentSize=nextSize;
            nextSize=0;
        }
        return res;

    }
}
