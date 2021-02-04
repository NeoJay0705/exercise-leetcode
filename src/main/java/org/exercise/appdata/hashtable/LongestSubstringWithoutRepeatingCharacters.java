package org.exercise.appdata.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3
// can improve

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for ( int i = 0; i < s.length(); ++i ) {
            Set<Character> seens = new HashSet<>();
            seens.add(s.charAt(i));
            int count = 1;
            for ( int j = i + 1 ; j < s.length(); ++j ) {
                if ( !seens.contains(s.charAt(j)) ) {
                    seens.add(s.charAt(j));
                    count++;
                }
                else break;
            }
            maxLen = count > maxLen ? count : maxLen;
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringAlmostPass(String s) {
        int maxLen = 0;
        int tmpLen = 0;
        int lastIndex = 0;
        Set<Character> seens = new HashSet<>();
        
        for ( int i = 0; i < s.length(); ++i ) {
            if ( !seens.contains(s.charAt(i)) ) {
                seens.add(s.charAt(i));
                tmpLen++;
                if ( tmpLen > maxLen ) maxLen = tmpLen;
            }
            else {
                for ( ; s.charAt(lastIndex) != s.charAt(i); ++lastIndex ) {
                    seens.remove(s.charAt(lastIndex));
                    tmpLen--;
                }
                lastIndex++;
            }
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringOnePass(String s) {
        int maxLen = 0;
        int tmpLen = 0;
        int lastIndex = 0;
        Map<Character, Integer> seens = new HashMap<>();

        for ( int i = 0; i < s.length(); ++i ) {
            if ( !seens.containsKey(s.charAt(i)) ) {
                seens.put(s.charAt(i), i);
                tmpLen++;
                if ( tmpLen > maxLen ) maxLen = tmpLen;
            }
            else {
                for ( ; s.charAt(lastIndex) != s.charAt(i); ++lastIndex ) {
                    seens.remove(s.charAt(lastIndex));
                    tmpLen--;
                }
                lastIndex++;
            }
        }

        return maxLen;
    }
}
