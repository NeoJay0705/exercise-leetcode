package org.exercise.linkedlist;

import org.exercise.inputs.ListNode;

// 19
// Can be improved

public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList rnnfel = new RemoveNthNodeFromEndofList();
        ListNode[] inputs = new ListNode[] {
                                             new ListNode(1).apd(2).apd(3).apd(4).apd(5),
                                             new ListNode(1).apd(2).apd(3).apd(4).apd(5),
                                             new ListNode(1).apd(2).apd(3).apd(4).apd(5),
                                             new ListNode(1).apd(2).apd(3).apd(4).apd(5),
                                             null
                                           };
        int[] intInputs = new int[] { 1,3,5,6,3 };
        for ( int i = 0; i < inputs.length; i++ ) {
            ListNode result = rnnfel.removeNthFromEnd(inputs[i], intInputs[i]);
            while( result != null ) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            System.out.println();
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;
        while ( tmp != null ) {
            len++;
            tmp = tmp.next;
        }

        tmp = head;
        if ( len == n ) {
            tmp = tmp.next;
            head = tmp;
        }
        else if ( n < len ) {
            for ( int i = 0; i < len - n - 1; i++ ) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        }
        return head;
    }
}
