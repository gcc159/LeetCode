package Stack.Binary_Tree_Zigzag_Level_Order_Traversal;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> nodePriorityQueue=new LinkedList<>(
        );
        Queue<Integer> countPriorityQueue=new LinkedList<>();

        nodePriorityQueue.add(root);
        countPriorityQueue.add(1);
        int state=0;
        while(!nodePriorityQueue.isEmpty()){
            int nextLevel=0;
            List<Integer> current=new ArrayList<>();
            int currentLevel=countPriorityQueue.poll();
            for(int i=0;i<currentLevel;i++){
                TreeNode currentNode=nodePriorityQueue.poll();
                if(currentNode!=null){
                    current.add(currentNode.val);
                    if(currentNode.left!=null) {
                        nodePriorityQueue.add(currentNode.left);
                        nextLevel++;
                    }
                    if(currentNode.right!=null) {
                        nodePriorityQueue.add(currentNode.right);
                        nextLevel++;
                    }

                }
            }
            countPriorityQueue.add(nextLevel);
            if(state==1)

                Collections.reverse(current);
            res.add(current);
            state=(state+1)%2;


        }

        return res;
    }
}
