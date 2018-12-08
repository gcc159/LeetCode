package LinkedList.Convert_Sorted_List_to_Binary_Search_Tree;

import Util.ListNode;
import Util.TreeNode;

import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int size=0;
        ListNode current=head;
        while(current!=null){
            current=current.next;
            size++;
        }
        return generateTreeNode(size,head);

    }
    private TreeNode generateTreeNode(int size, ListNode start){
        if(size==0) return null;
        if(size==1){
            TreeNode treeNode=new TreeNode(start.val);
            treeNode.left=null;
            treeNode.right=null;
            return treeNode;
        }
        if(size==2){
            TreeNode treeNode1=new TreeNode(start.val);
            TreeNode treeNode2=new TreeNode(start.next.val);
            treeNode2.left=treeNode1;
            treeNode2.right=null;
            return treeNode2;
        }
        if(size==3){
            TreeNode treeNode1=new TreeNode(start.val);
            TreeNode treeNode2=new TreeNode(start.next.val);
            TreeNode treeNode3=new TreeNode(start.next.next.val);
            treeNode2.left=treeNode1;
            treeNode2.right=treeNode3;
            return treeNode2;
        }
        ListNode current=start;
        int i=0;
        while(i<(Math.floor(size/2)-1)){
            current=current.next;
            i++;
        }
        ListNode currentRoot=current.next;
        current.next=null;
        TreeNode root=new TreeNode(currentRoot.val);
        root.left=generateTreeNode(i+1,start);
        root.right=generateTreeNode(size-i-2,currentRoot.next);
        return root;
    }

    public static void main(String args[]){
        int []nums={-10,-3,0,5,9};
        ListNode head=new ListNode(0);
        ListNode start=head;
        for(int i=0;i<nums.length;i++){
            start.next=new ListNode(nums[i]);
            start=start.next;
        }
        start.next=null;
        Solution solution=new Solution();
        solution.sortedListToBST(head.next);

    }
}
