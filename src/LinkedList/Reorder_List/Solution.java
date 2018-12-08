package LinkedList.Reorder_List;

import Util.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/***
 * 最优解的方法没有使用栈的结构，首先使用快慢指针的方法找到左右子链表的分界点
 * ，然后对右子链表进行逆序操作，最后对左右子链表进行归并操作。
 */
public class Solution {
    public void reorderList(ListNode head) {
        int size=0;
        if(head==null||head.next==null) return;
        ListNode start=head;
        while(start!=null){
            start=start.next;
            size++;
        }
        boolean isEven=false;
        if(size%2==0) isEven=true;
        start=head;
        for(int i=0;i<Math.ceil(size/2.0);i++)
            start=start.next;
        Stack<ListNode> stack = new Stack<>();
        while(start!=null){
            stack.push(start);
            start=start.next;
        }
        start=head;
        for(int i=0;i<size/2-1;i++){
            ListNode next=start.next;
            start.next=stack.pop();
            start.next.next=next;
            start=next;
        }
        if(isEven){
            start.next=stack.pop();
            start.next.next=null;
        }else{
            ListNode next=start.next;
            start.next=stack.pop();
            start.next.next=next;
            start=next;
            start.next=null;
        }

    }
}
