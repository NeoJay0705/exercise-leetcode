package org.exercise.string;

// 28

public class StrStr {
    // win 50% 
    public int strStr(String haystack, String needle) {
        if ( needle.length() == 0 ) return 0;

        int offset = 0;

        for ( ; offset + needle.length() - 1 < haystack.length(); ) {
            
            int j = 0;
            for ( ; j < needle.length() 
                    &&  needle.charAt(j) == haystack.charAt(offset + j); ++j ) {
            }

            if ( j == needle.length() ) return offset;

            offset++;
        }

        return -1;
    }
}
