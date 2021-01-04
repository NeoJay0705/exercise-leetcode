package org.exercise.string;

// 14
// Can use dividing

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();

        String[][] ss = new String[][]{ {}, {""}, {"aaa"}, {"a", "b"}, {"123", "1234", "12345"}, {"123", "1234", "12"}, {"123", "12", "1234"}, {"123", "12", "1"} };
        for (String[] s : ss) {
            System.out.println(l.longestCommonPrefix(s));
        } 
    }

    public String longestCommonPrefix(String[] strs) {
        if ( strs.length == 0 ) return "";

        int lastIndex = strs[0].length() - 1;

        for ( int i = 0; i < strs.length - 1 && lastIndex > -1; ++i ) {
            int shortestIndex = strs[i].length() < strs[i + 1].length() ? i : i + 1;
            int longestCount = -1;
            for ( int j = 0; j < lastIndex + 1 && j < strs[shortestIndex].length() && strs[i].charAt(j) == strs[i + 1].charAt(j); ++j ) {
                   longestCount++;
            }

            if ( longestCount < lastIndex ) lastIndex = longestCount;
        }

        return strs[0].substring(0, lastIndex < 0 ? 0 : lastIndex + 1);
    }
}
