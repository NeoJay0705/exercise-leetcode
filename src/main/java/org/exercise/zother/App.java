package org.exercise.zother;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    enum Test {MON()}
    public static void main( String[] args )
    {
        Deque<String> stack = new LinkedList<>();
        stack.offerLast(null);
        stack.offerLast(null);
        stack.offerLast(null);
        System.out.println(stack.size());
    }
}
