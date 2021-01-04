package org.exercise.linkedlist;

// # 707

public class MyDoubleLinkedList {
    private class Node {
        int val;
        Node next;
        Node pre;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    /** Initialize your data structure here. */
    public MyDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if ( index >= length ) return -1;

        Node tmp;
        if ( index >= ( length - 1 ) / 2 ) {
            tmp = tail;
            for ( int i = 0; i < length - index - 1; ++i ) {
                tmp = tmp.pre;
            }
        } else {
            tmp = head;
            for ( int i = 0; i < index ; ++i ) {
                tmp = tmp.next;
            }
        }

        return tmp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        if ( head != null ) head.pre = newNode;
        if ( tail == null ) tail = newNode;
        head = newNode;

        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.pre = tail;
        if ( tail != null ) tail.next = newNode;
        if ( head == null ) head = newNode;
        tail = newNode;

        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if ( index > length ) return;

        if ( index == 0 ) {
            addAtHead(val);
        }
        else if ( index == length ) {
            addAtTail(val);
        }
        else {
            Node newNode = new Node(val);

            if ( index >= ( length - 1 ) / 2 ) {
                Node tmp = tail;
                for ( int i = 0; i < length - index - 1; ++i ) {
                    tmp = tmp.pre;
                }

                newNode.pre = tmp.pre;
                newNode.next = tmp;
                tmp.pre.next = newNode;
                tmp.pre = newNode;
            } else {
                Node tmp = head;
                for ( int i = 0; i < index - 1; ++i ) {
                    tmp = tmp.next;
                }

                newNode.next = tmp.next;
                newNode.pre = tmp;
                tmp.next.pre = newNode;
                tmp.next = newNode;
            }
    
            length++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if ( head == null || index >= length ) return;

        if ( index == 0 ) {
            if ( head.next != null ) head.next.pre = null;
            else tail = null;
            head = head.next;
        }
        else if ( index == length - 1 ) {
            if ( tail.pre != null ) tail.pre.next = null;
            else head = null;
            tail = tail.pre;
        }
        else {
            Node tmp;
            if ( index >= ( length - 1 ) / 2 ) {
                tmp = tail;
                for ( int i = 0; i < length - index - 1; ++i ) {
                    tmp = tmp.pre;
                }
            } else {
                tmp = head;
                for ( int i = 0; i < index ; ++i ) {
                    tmp = tmp.next;
                }
            }

            tmp.pre.next = tmp.next;
            tmp.next.pre = tmp.pre;
        }
        
        length--;
    }
}