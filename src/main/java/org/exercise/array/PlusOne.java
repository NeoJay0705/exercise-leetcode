package org.exercise.array;

import java.util.Arrays;

// 66

public class PlusOne {
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[][] inputs = new int[][] {
                                        new int[]{1},
                                        new int[]{9},
                                        new int[]{1,2},
                                        new int[]{1,9},
                                        new int[]{9,9}                           
                                     };
        for ( int[] input : inputs ) {
            int[] result = po.plusOne(input);
            for ( int i : result ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[] plusOne(int[] digits) {
        int[] secDigits = new int[]{1};
        
        int maxLen = Math.max(digits.length, secDigits.length);
        int[] result = new int[maxLen + 1];

        int carry = 0;
        int i = digits.length - 1, j = secDigits.length - 1;
        for ( ; (i > -1 && j > -1) || carry == 1 ; --i, --j, --maxLen ) {
            int sum = (i < 0 ? 0 : digits[i]) + carry + (j < 0 ? 0 : secDigits[j]);
            int digit = sum % 10;
            carry = sum / 10;
            result[maxLen] = digit;
        }

        if ( i > -1 ) {
            for ( int c = i; c > -1; --c, --maxLen ) {
                result[maxLen] = digits[c];
            }
        }
        else if ( j > -1 ) {
            for ( int c = j; c > -1; --c, --maxLen ) {
                result[maxLen] = secDigits[c];
            }
        }

        return result[0] == 1 ? result : Arrays.copyOfRange(result, 1, result.length);
    }   
}
