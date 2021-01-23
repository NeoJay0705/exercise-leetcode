package org.exercise.algo.recursive;

import java.util.HashMap;
import java.util.Map;

// 70

public class ClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if ( cache.containsKey(n) ) return cache.get(n);
        if ( n < 3 ) return n;

        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);
        return result;
    }
}
