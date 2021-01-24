package org.exercise.linkedlist;

import java.util.Stack;
import org.exercise.zother.inputs.Node;

// 430

public class FlattenaMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        Stack<Node> s = new Stack<>();
        Node cur = head;
        for ( ; cur != null; ) {
            Node tmp = cur;
            if ( cur.child != null ) {
                s.push(cur.next); // possible to be null value
                cur.next = cur.child;
                cur.child = null;
            }
            cur = cur.next;

            for ( ; cur == null && !s.empty(); ) {
                cur = s.pop();
            }

            if ( cur != null ) {
                cur.prev = tmp;
                tmp.next = cur;
            }
        }

        return head;
    }
}
