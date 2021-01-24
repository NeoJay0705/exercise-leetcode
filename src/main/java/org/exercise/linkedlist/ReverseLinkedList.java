package org.exercise.linkedlist;

import org.exercise.zother.inputs.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode[] inputs = new ListNode[] {
                                             new ListNode(1).apd(2).apd(3),
                                             null,
                                             new ListNode(1),
                                             new ListNode(1).apd(2)     
                                           };

        for ( ListNode input : inputs ) {
            ListNode result = rll.reverseList_rec(input);
            while ( result != null ) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            System.out.println("null\n");
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode tmpHead = head;
        while ( tmpHead != null ) {
            head = tmpHead;
            ListNode tmp = tmpHead.next;
            tmpHead.next = p;
            p = tmpHead;
            tmpHead = tmp;
        }
        return head;
    }

    ListNode newHead;
    int totalCount = 0;
    public ListNode reverseList_rec(ListNode head) {
        if ( head == null ) return null;
        int count = totalCount++;
        ListNode result = reverseList_rec(head.next);
        head.next = null;
        if ( result == null ) newHead = head;
        else {
            result.next = head;
        }
        if ( count == 0 ) {
            totalCount = 0;
            return newHead;
        } 
        else return head;
    }
}
