package LinkedList.Insertion_Sort_List;

import Util.ListNode;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode current=head.next;
        int count =1;
        while(current!=null){
            ListNode next=current.next;
            ListNode start=newHead;
            for(int i=0;i<count;i++){
                if(current.val<start.next.val)
                    break;
                start=start.next;
            }
            ListNode sortNext=start.next;
            count++;
            start.next=current;
            current.next=sortNext;
            current=next;

        }

        ListNode start=newHead;
        for(int i=0;i<=count;i++)
            start=start.next;
        start.next=null;
        return newHead.next;
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
        solution.insertionSortList(head.next);
    }
}
