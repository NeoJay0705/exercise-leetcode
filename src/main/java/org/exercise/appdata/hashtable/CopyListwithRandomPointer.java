package org.exercise.appdata.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.exercise.zother.inputs.Node;

// 138

public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodes = new HashMap<>();
        Map<Node, List<Node>> pendings = new HashMap<>();

        Node headCursor = head;
        Node cloned = new Node(0);
        Node clonedCursor = cloned;
        while ( headCursor != null ) {
            Node newNode = new Node(headCursor.val);
            nodes.put(headCursor, newNode);

            if ( headCursor.random != null ) {
                if ( nodes.containsKey(headCursor.random) ) 
                    newNode.random = nodes.get(headCursor.random);
                else {
                    List<Node> ls = pendings.get(headCursor.random);
                    if ( ls == null ) {
                        ls = new ArrayList<>();
                        pendings.put(headCursor.random, ls);
                    }
                    ls.add(newNode);
                }
            }
            
            List<Node> pending = pendings.get(headCursor);
            if ( pending != null ) {
                for ( Node pre : pending ) {
                    pre.random = newNode;
                }
                pendings.remove(headCursor);
            }
            
            clonedCursor.next = newNode;
            clonedCursor = clonedCursor.next;
            headCursor = headCursor.next;
        }

        return cloned.next;
    }
}
