package org.exercise.linkedlist;

import org.exercise.inputs.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        int i = 0;
        while ( fast != null ) {
            slow = slow.next;
            fast = fast.next;
            if ( fast != null ) fast = fast.next;
            i++;
            if ( slow == fast && slow != null ) return true;
        }

        return null;
    }
}
