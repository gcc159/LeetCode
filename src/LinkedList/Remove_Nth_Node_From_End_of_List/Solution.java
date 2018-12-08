package LinkedList.Remove_Nth_Node_From_End_of_List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start=new ListNode(0);

        ListNode first=start;ListNode second=start;
        start.next=head;
        for(int i=0;i<n+1;i++)
            first=first.next;
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return start.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
