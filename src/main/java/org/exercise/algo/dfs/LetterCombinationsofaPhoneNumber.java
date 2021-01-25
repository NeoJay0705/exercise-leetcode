package org.exercise.algo.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17

public class LetterCombinationsofaPhoneNumber {
    private Map<String, String[]> maps;
    public LetterCombinationsofaPhoneNumber() {
        maps = new HashMap<>();
        maps.put("0", new String[]{});
        maps.put("1", new String[]{});
        maps.put("2", new String[]{"a", "b", "c"});
        maps.put("3", new String[]{"d", "e", "f"});
        maps.put("4", new String[]{"g", "h", "i"});
        maps.put("5", new String[]{"j", "k", "l"});
        maps.put("6", new String[]{"m", "n", "o"});
        maps.put("7", new String[]{"p", "q", "r", "s"});
        maps.put("8", new String[]{"t", "u", "v"});
        maps.put("9", new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        String[][] ss = new String[digits.length()][];
        for ( int i = 0; i < ss.length; ++i ) {
            ss[i] = maps.get(String.valueOf(digits.charAt(i)));
        }

        helper("", ss, 0, result);

        return result;
    }

    public void helper(String s, String[][] ss, int itr, List<String> result) {
        if ( ss.length == 0 ) return;

        if ( itr == ss.length - 1 ) {
            for ( int i = 0; i < ss[itr].length; ++i ) {
                result.add(s + ss[itr][i]);
            }
            return;
        }

        for ( int i = 0; i < ss[itr].length; ++i ) {
            helper(s + ss[itr][i], ss, itr + 1, result);
        }
    }
}
