package LinkedList.Reverse_Linked_List_II;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start=new ListNode(0);
        start.next=null;
        start.next=head;
        ListNode left=null,innerRight=null,innerLeft=null,right=null,previous,next=null;

        left=start;
        int i=0;
        ListNode current=start;
        while(current!=null){
            i++;
            if(i<m)
                current=current.next;

            else {
                if (m == i) {
                    left = current;
                    innerRight = current.next;
                    current=current.next;
                    next=current.next;
                }else if(i<=n){
                    previous=current;
                    current=next;
                    next=current.next;
                    current.next=previous;
                }else{
                    right=next;
                    innerLeft=current;
                    break;
                }
            }
        }

        left.next=innerLeft;
        innerRight.next=right;

        return start.next;
    }

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static void main(String[] args){
        Solution solution=new Solution();
        int[] nums={1,2,3,4,5};
        solution.reverseBetween(solution.generateAList(nums),2,4);

    }
    private ListNode generateAList(int []nums){
        ListNode head=new ListNode(0);
        ListNode current=head;
        for(int i=0;i<nums.length;i++){
            current.next=new ListNode(nums[i]);
            current=current.next;
        }
        current.next=null;
        return head.next;
    }
}
