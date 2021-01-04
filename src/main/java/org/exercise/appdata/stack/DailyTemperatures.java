package org.exercise.appdata.stack;

import java.lang.Thread.State;
import java.util.Deque;
import java.util.LinkedList;

// 739
// Think
// Can improve

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[][] inputs = new int[][] {
                                        {1},
                                        {1,1},
                                        {1,2},
                                        {1,2,1,3},
                                        {1,2,1,0}
                                     };
        for ( int[] input : inputs ) {
            int[] result = dt.dailyTemperatures(input);
            for ( int i : result ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();;
        int[] result = new int[T.length];
        for ( int i = 0; i < T.length; ++i ) {
            
            for ( int topIndex = stack.peekLast() == null ? -1 : stack.peekLast() ; 
                    topIndex != -1 && T[i] > T[topIndex]; 
                    topIndex = stack.peekLast() == null ? -1 : stack.peekLast() ) {
                result[topIndex] = i - topIndex;
                stack.pollLast();
            }

            stack.offerLast(i);
            
        }
        return result;
    }
}
