package org.exercise.linkedlist;

import org.exercise.inputs.ListNode;

// 61

public class RotateList {
    public static void main(String[] args) {
        RotateList rl = new RotateList();
        ListNode[] inputs = new ListNode[] {
                                             null,
                                             new ListNode(1), // 1
                                             new ListNode(1).apd(2), // 1
                                             new ListNode(1).apd(2), // 2
                                             new ListNode(1).apd(2).apd(3).apd(4).apd(5).apd(6), // 3
                                           };
        int[] intInputs = new int[] { 1,1,1,2,3 };
        for ( int i = 0; i < inputs.length; i++ ) {
            ListNode result = rl.rotateRight(inputs[i], intInputs[i]);
            while ( result != null ) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            System.out.println();
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null ) return null;

        int count = 0;
        ListNode tmp = head;
        ListNode tail = null;
        while ( tmp != null ) {
            count++;
            if ( tmp.next == null ) tail = tmp;
            tmp = tmp.next;
        }
        k %= count;

        tmp = head;
        for ( int i = 0; i < count - k - 1; i++ ) {
            tmp = tmp.next;
        }
        tail.next = head;
        head = tmp.next;
        tmp.next = null;

        return head;
    }
}
