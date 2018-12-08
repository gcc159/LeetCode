package LinkedList.Copy_List_with_Random_Pointer;

import Util.ListNode;

import java.util.*;

public class Solution {
    public RandomListNode copyRandomList_2(RandomListNode head) {

        RandomListNode current=head;
        if(head==null) return null;

        while(current!=null){
            RandomListNode next=current.next;
            current.next=new RandomListNode(current.label);
            current.next.next=next;
            current=next;
        }
        current=head;
        while(current!=null){
            if(current.random!=null)
                current.next.random=current.random.next;
            RandomListNode next=current.next.next;
            current.next.next=current.next.next!=null?current.next.next.next:null;
            current=next;
        }
        return head.next;


    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        map.put(null,null);
        RandomListNode current=head;
        if(head==null) return null;
        while(current!=null){
            if(map.get(current)==null){
                map.put(current,new RandomListNode(current.label));
            }
            current=current.next;
        }
        current=head;
        while(current!=null){
            map.get(current).next=map.get(current.next);
            map.get(current).random=current.random!=null?map.get(current.random):null;
            current=current.next;
        }
        return map.get(head);
    }

    class RandomListNode {
       int label;
       RandomListNode next, random;
       RandomListNode(int x) { this.label = x; }
   };
}
