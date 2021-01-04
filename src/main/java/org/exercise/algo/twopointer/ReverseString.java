package org.exercise.algo.twopointer;

// 344

public class ReverseString {
    public void reverseString(char[] s) {
        for ( int left = 0, right = s.length - 1; left < right; left++, right-- ) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
