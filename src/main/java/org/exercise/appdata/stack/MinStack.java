package org.exercise.appdata.stack;

// 155
// Can improve

public class MinStack {
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    Node top;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        this.top = null;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if ( top == null ) {
            top = new Node(x);
        }
        else {
            Node newNode = new Node(x);
            newNode.next = top;
            top = newNode;
        }
        min = Math.min(min, x);
    }
    
    public void pop() {
        if ( min == top.val ) {
            Node tmp;
            if ( top.next == null ) {
                min = Integer.MAX_VALUE;
                tmp = null;
            }
            else {
                min = top.next.val;
                tmp = top.next.next;
            }
            while ( tmp != null ) {
                min = Math.min(tmp.val, min);
                tmp = tmp.next;
            }
        }
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return min;
    }
}
