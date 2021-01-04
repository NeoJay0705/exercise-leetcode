package org.exercise.algo.bfs;

import java.util.HashSet;
import java.util.Set;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for ( int i = 0; i < deadends.length; i++ ) {
            set.add(deadends[i]);
        }
        int result = bfs(set, target) + 1;
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int bfs(Set<String> deadends, String target) {
        if ( deadends.contains(target) ) return Integer.MAX_VALUE - 1;
        if ( target.equals("0000") ) return 0;
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(target);
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(0) - '0' + 1) % 10)).toString())); // 1+1
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(0) - '0' - 1 == -1 ? 9 : sb.charAt(0) - '0' - 1) % 10)).toString())); // 1-1
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(1) - '0' + 1) % 10)).toString())); // 2+1
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(1) - '0' - 1 == -1 ? 9 : sb.charAt(1) - '0' - 1) % 10)).toString())); // 2-1
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(2) - '0' + 1) % 10)).toString())); // 3+1
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(2) - '0' - 1 == -1 ? 9 : sb.charAt(2) - '0' - 1) % 10)).toString())); // 3-1
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(3) - '0' + 1) % 10)).toString())); // 4+1
        
        min = Math.min(min, bfs(deadends, new StringBuilder(target).replace(0, 1, String.valueOf((sb.charAt(3) - '0' - 1 == -1 ? 9 : sb.charAt(3) - '0' - 1) % 10)).toString())); // 4-1
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE - 1 : min + 1;
    }
}
