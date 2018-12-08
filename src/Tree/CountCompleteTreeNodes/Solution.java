package Tree.CountCompleteTreeNodes;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int h=getHight(root);
        int count=0;
        while(root!=null){
            if(getHight(root.right)==h-1) {
                count += 1 << (h-1);
                root=root.right;
            }else{
                count+=1<<(h-2);
                root=root.left;
            }
            h--;
        }
        return count;
    }

    private int getHight(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.left;
            depth++;
        }
        return depth;
    }

}
