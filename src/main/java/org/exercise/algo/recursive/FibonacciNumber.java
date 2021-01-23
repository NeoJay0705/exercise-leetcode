package org.exercise.algo.recursive;

import java.util.HashMap;
import java.util.Map;

// 509

public class FibonacciNumber {
    Map<Integer, Integer> cache = new HashMap<>();

    public int fib_rec(int n) {
        if ( cache.containsKey(n) ) return cache.get(n);
        if ( n < 2) return n;

        int result = fib_rec(n - 1) + fib_rec(n - 2);
        cache.put(n, result);
        
        return result;
    }

    public int fib(int n) {
        int[] fibs = new int[n + 1];
        
        for ( int i = 0; i < fibs.length; ++i ) {
            if ( i == 0 || i == 1) {
                fibs[i] = i;
            }
            else {
                fibs[i] = fibs[i - 1] + fibs[i - 2];
            }
        }

        return fibs[n];
    }
}
