package org.exercise.appdata.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementStackusingQueues {
    Deque<Integer> popQueue = new LinkedList<>();
    Deque<Integer> pushQueue = new LinkedList<>();

    /** Initialize your data structure here. */
    public ImplementStackusingQueues() {
        // 
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        pushQueue.offerLast(x);
        if ( pushQueue.size() > 1 ) {
            for ( int i = 0; i < pushQueue.size() - 1; ++i ) {
                pushQueue.offerLast(pushQueue.pollFirst());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // Redundent
        // if ( popQueue.isEmpty() ) {
        //     for ( ; !pushQueue.isEmpty(); ) {
        //         popQueue.offerLast(pushQueue.pollFirst());
        //     }
        // }
        // return popQueue.pollFirst();
        return pushQueue.pollFirst();
    }
    
    /** Get the top element. */
    public int top() {
        // Redundent
        // return popQueue.peekFirst() == null ? pushQueue.peekFirst() : popQueue.peekFirst();
        return pushQueue.peekFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return popQueue.isEmpty() && pushQueue.isEmpty();
    }
}
