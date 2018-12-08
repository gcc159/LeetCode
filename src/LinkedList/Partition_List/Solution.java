package LinkedList.Partition_List;

import java.util.List;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode firstHead=new ListNode(0);
        ListNode secondHead=new ListNode(0);
        ListNode first=firstHead;
        ListNode second=secondHead;

        ListNode current=head;
        while(current!=null){
            if(current.val<x){
                first.next=current;
                first=first.next;
            }else{
                second.next=current;
                second=second.next;
            }
            current=current.next;
        }
        second.next=null;
        first.next=secondHead.next;
        return firstHead.next;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

}
