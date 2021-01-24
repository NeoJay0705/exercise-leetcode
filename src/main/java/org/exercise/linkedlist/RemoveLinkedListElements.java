package org.exercise.linkedlist;

import org.exercise.zother.inputs.ListNode;

// 203

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements rlle = new RemoveLinkedListElements();
        ListNode[] inputs = new ListNode[] {
                                             null,
                                             new ListNode(1),
                                             new ListNode(2),
                                             new ListNode(1).apd(1).apd(2),
                                             new ListNode(1).apd(2).apd(1),
                                             new ListNode(2).apd(1).apd(1),
                                             new ListNode(2).apd(1).apd(2),
                                             new ListNode(2).apd(2).apd(2),
                                           };
        for ( ListNode input : inputs ) {
            ListNode result = rlle.removeElements(input, 1);
            while ( result != null ) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            System.out.println();
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = head;
        ListNode pre = tmp;

        while ( tmp != null ) { 
            if ( tmp.val != val ) {
                pre = tmp;
                tmp = tmp.next;
            }
            else if ( tmp != head ) {
                pre.next = tmp.next;
                tmp = tmp.next;
            }
            else {
                pre = pre.next;
                tmp = tmp.next;
                head = tmp;
            }
        }

        return head;
    }
}
