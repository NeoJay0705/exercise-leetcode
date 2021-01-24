package org.exercise.zother.tbd;

public class LongestSubstringWithout3ContiguousOccurrencesofLetter {

    private LongestSubstringWithout3ContiguousOccurrencesofLetter() {}

    public static String solutionOptimized(String s) {
        

        return "";
    }

    // This solution use extra space to store result.
    // The better way is to store index of start and end, instead of entire string.
    public static String solution(String s) {
        if (s == null) return "";

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int maxLen = 1;
            StringBuilder tmp = new StringBuilder(s.charAt(i));
            for (int j = i + 1; j < s.length() && maxLen < 3; i++, j++) {
                if (s.charAt(i) == s.charAt(j)) 
                    maxLen++;
                else 
                    maxLen = 1;

                if (maxLen < 3)
                    tmp.append(s.charAt(j));
            }
            i--;
            if (result.length() < tmp.toString().length()) {
                result = tmp.toString();
            }
        }

        return result;
    }
}
