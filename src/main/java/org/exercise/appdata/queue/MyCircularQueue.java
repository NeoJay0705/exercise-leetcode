package org.exercise.appdata.queue;

// 622

public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue mcq = new MyCircularQueue(3);
        System.out.println();
        System.out.println(mcq.enQueue(1)); // 1
        System.out.println(mcq.enQueue(2)); // 1 2
        System.out.println(mcq.Front());    // r 1
        System.out.println(mcq.deQueue());  // _ 2
        System.out.println(mcq.enQueue(3)); // _ 2 3
        System.out.println(mcq.enQueue(4)); // 4 2 3
        System.out.println(mcq.Front());    // r 2
        System.out.println(mcq.deQueue());  // 4 _ 3
        System.out.println(mcq.Front());    // r 3
        System.out.println(mcq.deQueue());  // 4 _ _
        System.out.println(mcq.Front());    // r 4
        System.out.println(mcq.deQueue());  // _ _ _
        System.out.println(mcq.Front());    // -1
        System.out.println(mcq.deQueue());  // false
        System.out.println(mcq.enQueue(2)); // _ 2 _
        System.out.println(mcq.enQueue(3)); // _ 2 3
        System.out.println(mcq.Front());    // r 2
        System.out.println(mcq.deQueue());  // _ _ 3
    }

    int[] queue;
    int popIndex;
    int tailIndex;

    public MyCircularQueue(int k) {
        this.queue = new int[k]; 
        this.popIndex = -1;
        this.tailIndex = 0;
    }
    
    public boolean enQueue(int value) {
        if ( isFull() ) return false;
        tailIndex = ++tailIndex % queue.length;
        if ( isEmpty() ) popIndex = tailIndex;
        queue[tailIndex] = value;
        return true;
    }
    
    public boolean deQueue() {
        if ( isEmpty() ) return false;
        if ( popIndex == tailIndex ) popIndex = -1;
        else popIndex = ++popIndex % queue.length;
        return true;
    }
    
    public int Front() {
        if ( isEmpty() ) return -1;
        return queue[popIndex];
    }
    
    public int Rear() {
        if ( isEmpty() ) return -1;
        return queue[tailIndex];
    }
    
    public boolean isEmpty() {
        return popIndex == -1;
    }
    
    public boolean isFull() {
        return (tailIndex + 1) % queue.length == popIndex;
    }
}
