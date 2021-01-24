package org.exercise.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.exercise.zother.inputs.ListNode;

// 141

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle llc = new LinkedListCycle();
        ListNode[] inputs = new ListNode[]{
                                            new ListNode(1).apd(2).apd(3).apd(3),
                                            new ListNode(1).apd(2).apd(3,1),
                                            new ListNode(1).apd(2).apd(3, 0),
                                          };
        for ( ListNode input : inputs ) {
            System.out.println(llc.hasCycle2(input));
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> visted = new HashSet<>();
        ListNode tmp = head;
        while( !visted.contains(tmp) && tmp != null ) {
            visted.add(tmp);
            tmp = tmp.next;
        }
        return tmp == null ? false : true;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while ( fast != null ) {
            slow = slow.next;
            fast = fast.next;
            if ( fast != null ) fast = fast.next;
            if ( slow == fast && slow != null ) return true;
        }

        return false;
    } 
}
