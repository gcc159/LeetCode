package Tree.Unique_Binary_Search_Trees_II;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        int []nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        return generateTrees(nums,0,n-1);
    }

    private  List<TreeNode> generateTrees(int []nums,int startIndex,int endIndex){
        List<TreeNode> res= new ArrayList<>();
        if(startIndex>endIndex) {
            TreeNode node =new TreeNode(0);
            node.left=node.right=null;
            res.add(node);
            return res;
        }
        if(startIndex==endIndex){
            TreeNode node =new TreeNode(nums[startIndex]);
            node.left=node.right=null;
            res.add(node);
            return res;
        }
        for(int rootIndex=startIndex;rootIndex<=endIndex;rootIndex++){

            List<TreeNode> leftChilds=generateTrees(nums,startIndex,rootIndex-1);
            List<TreeNode> rightChilds=generateTrees(nums, rootIndex+1, endIndex);
            for(TreeNode leftChild :leftChilds)
                for(TreeNode rightChild:rightChilds){
                    TreeNode node=new TreeNode(nums[rootIndex]);
                    node.left=leftChild.val>0?leftChild:null;
                    node.right=rightChild.val>0?rightChild:null;
                    res.add(node);
                }
        }
        return res;
    }
}
