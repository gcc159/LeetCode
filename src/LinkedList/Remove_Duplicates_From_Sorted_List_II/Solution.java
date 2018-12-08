package LinkedList.Remove_Duplicates_From_Sorted_List_II;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode start=new ListNode(0);
        start.next=head;
        ListNode currentStart=start;
        ListNode current=head;
        while(current.next!=null){
            if(current.next.val==current.val){
                current=current.next;
            }else {
                if(currentStart.next!=current){
                    currentStart.next=current.next;
                }else{
                    currentStart=current;
                }
                current=current.next;
            }
        }
        if(currentStart.next!=current)
            currentStart.next=current.next;
        return start.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
