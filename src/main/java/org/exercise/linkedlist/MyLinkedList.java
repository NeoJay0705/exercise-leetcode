package org.exercise.linkedlist;

// # 707

public class MyLinkedList {
    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if ( index >= length ) return -1;

        Node tmp = head;

        for ( int i = 0; i < index; ++i) {
            tmp = tmp.next;
        }

        return tmp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if ( head == null ) {
            head = new Node(val);
        } else {
            Node tmp = head;
            while ( tmp.next != null ) {
                tmp = tmp.next;
            }   
            tmp.next = new Node(val);
        }

        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if ( index > length ) return;

        if ( index == 0 ) {
            addAtHead(val);
        }
        else {
            Node tmp = head;
            Node newNode = new Node(val);

            for ( int i = 0; i < index - 1; ++i ) {
                tmp = tmp.next;
            }
    
            newNode.next = tmp.next;
            tmp.next = newNode;
            length++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if ( head == null || index >= length ) return;

        if ( index == 0) {
            head = head.next;
        } 
        else {
            Node tmp = head;
            for ( int i = 0; i < index - 1; ++i ) {
                tmp = tmp.next;
            }

            tmp.next = tmp.next.next;
        }
        
        length--;
    }
}