package org.exercise.inputs;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode tail;
    public ListNode(int x) {
        this.val = x;
        next = null;
        tail = this;
    }

    public ListNode apd(int val) {
        ListNode aNew = new ListNode(val);
        return apd(aNew);
    }

    public ListNode apd(ListNode node) {
        tail.next = node;
        tail = tail.next;
        return this;
    }

    public ListNode apd(int val, int index) {
        ListNode aNew = new ListNode(val);
        ListNode tmp = this;
        for ( int i = 0; i < index; ++i ) {
            tmp = tmp.next;
        }
        aNew.next = tmp;
        return apd(aNew);
    }
}
