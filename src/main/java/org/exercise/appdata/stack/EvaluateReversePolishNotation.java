package org.exercise.appdata.stack;

import java.util.Deque;
import java.util.LinkedList;

// 150

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
        String[][] inputs = new String[][] {
                                                {"9", "11", "+", "80", "-"},  
                                                {"9", "11", "+", "80", "/"},
                                                {"9", "11", "+", "10", "/"},
                                                {"2","1","+","3","*"},
                                           };
        for ( String[] input : inputs ) {
            System.out.println(erpn.evalRPN(input));
        }
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> deq = new LinkedList<>();
        for ( int i = 0; i < tokens.length; ++i ) {
            String stuff = tokens[i];
            if ( stuff.equals("+") || stuff.equals("-") || stuff.equals("*") || stuff.equals("/") ) {
                int secNum = deq.pollLast();
                int firstNum = deq.pollLast();
                int val;
                switch (stuff) {
                    case "+":
                        val = firstNum + secNum;
                        break;
                    case "-":
                        val = firstNum - secNum;
                        break;
                    case "*":
                        val = firstNum * secNum;
                        break;
                    case "/":
                        val = firstNum / secNum;
                        break;
                    default:
                        val = 0;
                }
                deq.offerLast(val);
            }
            else {
                deq.offerLast(Integer.parseInt(stuff));
            }
        }
        return deq.pollLast();
    }
}
