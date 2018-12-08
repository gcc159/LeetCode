package LinkedList.Sort_List;

import Util.ListNode;

/***
 * 这个版本是使用归并排序的，但是查看最优解使用的是类似快速排序的方法。
 * 首先仍然是找到中间节点，然后同时建立一个左节点和一个右节点。比中间节点值小的节点
 * 放在左子链表中，大于的节点放在右子链表中。然后对两个子链表完成排序之后再和中间节点一起进行
 * 拼接。
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return backtracking(head);
    }

    public ListNode merge(ListNode first,ListNode second){
        ListNode head=new ListNode(0);
        ListNode current=head;
        while(first!=null&&second!=null){
            if(first.val<=second.val){
                current.next=first;
                first=first.next;
            }else{
                current.next=second;
                second=second.next;
            }
            current=current.next;
        }
        if(first!=null) current.next=first;
        if(second!=null) current.next=second;
        return head.next;
    }

    public ListNode backtracking(ListNode head){
        ListNode slow,fast,previous;
        slow=fast=head;
        if(head==null||head.next==null) return head;
        previous=null;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            previous=slow;
            fast=fast.next.next;
        }
        if(previous!=null)
            previous.next=null;
        ListNode l1=backtracking(head);
        ListNode l2=backtracking(slow);
        return merge(l1,l2);
    }

    public static void main(String[] args){
        int []nums={4,2,1,3};
        ListNode head=new ListNode(0);
        ListNode start=head;
        for(int i=0;i<nums.length;i++){
            start.next=new ListNode(nums[i]);
            start=start.next;
        }
        start.next=null;
        Solution solution=new Solution();
        solution.sortList(head.next);
    }
}
