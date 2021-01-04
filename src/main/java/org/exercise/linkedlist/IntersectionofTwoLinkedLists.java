package org.exercise.linkedlist;

import org.exercise.inputs.ListNode;

// 160

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ( headA == null || headB == null ) return null;

        ListNode a = headA;
        ListNode b = headB;

        while ( true ) {
            if ( a == b && a == null ) break;

            if ( a == null ) a = headB;
            if ( b == null ) b = headA;

            if ( a == b ) return a;

            a = a.next;
            b = b.next;
        }

        return null;
    }
}
