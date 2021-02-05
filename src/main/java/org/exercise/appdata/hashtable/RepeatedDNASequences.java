package org.exercise.appdata.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 187
// can improve

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeateds = new HashSet<>();
        Set<String> allStrings = new HashSet<>();

        for ( int i = 0; i + 9 < s.length() ; ++i ) {
            String sb = s.substring(i, 10 + i);
            if ( allStrings.contains(sb) ) {
                repeateds.add(sb);
            }
            allStrings.add(sb);
        }

        return new ArrayList<>(repeateds);
    }
}
