package org.exercise.appdata.stack;

import java.util.Deque;
import java.util.LinkedList;

// 20

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String[] inputs = new String[] {
                                            "",
                                            "(",
                                            ")",
                                            "()",
                                            ")(",
                                            "([",
                                            "(]",
                                            "()[",
                                            "([)",
                                            "[()",
                                            "([)]",
                                            "[()]",
                                            "(])[",
                                            "()[]",
                                       };
        for ( String input : inputs ) {
            System.out.println(vp.isValid(input));
        }
    }
    
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for ( int i = 0; i < s.length(); ++i ) {
            if ( s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ) {
                stack.offerLast(s.charAt(i));
            }
            else {
                if ( stack.isEmpty() ) return false;
                Character top = stack.pollLast();
                int diff = s.charAt(i) - top;
                if ( diff < 1 || diff > 2 ) return false; 
            }
        }
        return stack.isEmpty();
    }
}
