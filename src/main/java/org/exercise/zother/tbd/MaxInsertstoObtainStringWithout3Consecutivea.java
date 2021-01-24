package org.exercise.zother.tbd;

public class MaxInsertstoObtainStringWithout3Consecutivea {
    // all a
    // end with b
    public static int solution(String s) {
        int result = 0;
        int maxCon = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                maxCon++;
            }
            else {
                if (maxCon > 2) return -1; // Can improve
                result += 2 - maxCon;
                maxCon = 0;
            }
        }

        if (maxCon > 2) return -1;
        else result += 2 - maxCon ;

        return result;
    }
}
