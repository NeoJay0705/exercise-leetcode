package org.exercise;

public class LexicographicallySmallestString {
    
    private LexicographicallySmallestString() {}

    public static String solution(String s) {
        int removedIndex = -1;
        for (int i = 0; i + 1 < s.length() && removedIndex == -1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) 
                removedIndex = i;
        }

        removedIndex = removedIndex == -1 ? s.length() - 1 : removedIndex;

        return s.substring(0, removedIndex) 
               + s.substring(removedIndex + 1);
    }
}
