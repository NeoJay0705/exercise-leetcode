package org.exercise.algo.dfs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 841

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> isVisted = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> keys = rooms.get(0);
        isVisted.add(0);
        for ( Integer key : keys ) {
            stack.offerLast(key);
        }

        while ( !stack.isEmpty() ) {
            int nextRoom = stack.pollLast();
            if ( !isVisted.contains(nextRoom) ) {
                isVisted.add(nextRoom);
                keys = rooms.get(nextRoom);
                for ( Integer key : keys ) {
                    stack.offerLast(key);
                }
            }
        }
        return isVisted.size() == rooms.size();
    }
}
