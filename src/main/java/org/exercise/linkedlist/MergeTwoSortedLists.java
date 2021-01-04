package org.exercise.linkedlist;

import org.exercise.inputs.ListNode;

// 21

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        ListNode[][] inputs = new ListNode[][] {
                                                 {null, new ListNode(1)},
                                                 {new ListNode(1), null},
                                                 {null, null},
                                                 {new ListNode(1).apd(2).apd(3) , new ListNode(1).apd(1)},
                                                 {new ListNode(1).apd(2).apd(3) , new ListNode(0).apd(1)},
                                                 {new ListNode(1).apd(2).apd(3) , new ListNode(2).apd(3)},
                                               };
        for ( ListNode[] input : inputs ) {
            ListNode result = mtsl.mergeTwoLists(input[0], input[1]);
            while ( result != null ) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            System.out.println();
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null ) return l2;
        else if ( l2 == null ) return l1;

        ListNode result;
        if ( l1.val > l2.val ) {
            result = l2;
            l2 = l2.next;
        }
        else {
            result = l1;
            l1 = l1.next;
        }
        ListNode tmp = result;
        
        for ( ; l1 != null && l2 != null; ) {
            if ( l1.val > l2.val ) {
                tmp.next = l2;
                l2 = l2.next;
            }
            else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }

        if ( l1 != null ) tmp.next = l1;
        else tmp.next = l2;

        return result;
    }
}
