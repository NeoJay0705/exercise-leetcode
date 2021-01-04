package org.exercise.linkedlist;

import org.exercise.inputs.ListNode;

// 2

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode[][] inputs = new ListNode[][] {
                                                 {new ListNode(1).apd(2), new ListNode(1).apd(2)},
                                                 {new ListNode(1).apd(2), new ListNode(9).apd(2)},
                                                 {new ListNode(1).apd(2), new ListNode(9).apd(7)},
                                                 {new ListNode(1), new ListNode(1).apd(2)},
                                                 {new ListNode(1), new ListNode(9).apd(2)},
                                                 {new ListNode(1), new ListNode(9).apd(9)},
                                                 {null, new ListNode(1)},
                                                 {new ListNode(1), null},
                                                 {null, null}
                                               };
        for ( ListNode[] input : inputs ) {
            ListNode result = atn.addTwoNumbers(input[0], input[1]);
            while ( result != null ) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            System.out.println();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int base = 10;
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode tmp = result;

        for ( ; l1 != null || l2 != null || carry == 1; ) { 
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            int digit = sum % base;
            carry = sum / base;
            tmp.next = new ListNode(digit);
            tmp = tmp.next;
            
            if ( l1 != null ) l1 = l1.next;
            if ( l2 != null ) l2 = l2.next;
        }

        return result.next;
    }
}
