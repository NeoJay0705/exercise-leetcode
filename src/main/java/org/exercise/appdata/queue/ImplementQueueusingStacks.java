package org.exercise.appdata.queue;

import java.util.Deque;
import java.util.LinkedList;

// 232

public class ImplementQueueusingStacks {
    Deque<Integer> popStack = new LinkedList<>();
    Deque<Integer> pushStack = new LinkedList<>();

    /** Initialize your data structure here. */
    public ImplementQueueusingStacks() {
        // 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.offerLast(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if ( popStack.isEmpty() ) {
            for ( ; !pushStack.isEmpty(); ) {
                popStack.offerLast(pushStack.pollLast());
            }
        }
        return popStack.pollLast();
    }
    
    /** Get the front element. */
    public int peek() {
        if ( popStack.isEmpty() ) {
            for ( ; !pushStack.isEmpty(); ) {
                popStack.offerLast(pushStack.pollLast());
            }
        }
        return popStack.peekLast();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}
