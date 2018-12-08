package LinkedList.Add_Two_Number_II;

import Util.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean l1Larger=true;
        ListNode first=l1;
        ListNode second=l2;
        while(first!=null&&second!=null){
            first=first.next;

            second=second.next;
        }
        l1Larger=second==null;

        int count=0;
        ListNode head=new ListNode(0);
        if(l1Larger){
            while(first!=null){
                count++;
                first=first.next;
            }
            head.next=l1;
            second=l2;
        }else{
            while(second!=null){
                count++;
                second=second.next;
            }
            head.next=l2;
            second=l1;
        }

        ListNode pre=head;
        first=head.next;
        for(int i=0;i<count;i++){
            pre=first;
            first=first.next;
        }
        while(first!=null&&second!=null){
            first.val+=second.val;
            pre.val+=first.val/10;
            first.val=first.val%10;
            pre=first;
            first=first.next;
            second=second.next;
        }
        getCarry(head);
        if(head.val==0) return head.next;
        else return head;
    }
    private int getCarry(ListNode current){
        if(current==null) return 0;
        current.val+=getCarry(current.next);
        int res=current.val/10;
        current.val%=10;
        return res;
    }

    public static void main(String[] args){
        int []nums={9,9,9};
        ListNode l1=new ListNode(0);
        ListNode start=l1;
        for(int i=0;i<nums.length;i++){
            start.next=new ListNode(nums[i]);
            start=start.next;
        }
        start.next=null;
        ListNode l2=new ListNode(9);
        Solution solution=new Solution();
        solution.addTwoNumbers(l1.next,l2);
    }
}
