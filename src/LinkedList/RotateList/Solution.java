package LinkedList.RotateList;

public class Solution {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }

  public ListNode rotateRight(ListNode head, int k) {
        ListNode start=new ListNode(0);
        ListNode first=start;
        ListNode second=start;
        start.next=head;
        ListNode current=head;
        int total=0;

        while(current!=null){
            current=current.next;
            total++;
        }
        k=k%total;
        for(int i=0;i<k;i++)

            first=first.next;

        while(first.next!=null){
            first=first.next;
            second=second.next;
        }

        first.next=start.next;
        start.next=second.next;
        second.next=null;
        return start.next;



  }
}
