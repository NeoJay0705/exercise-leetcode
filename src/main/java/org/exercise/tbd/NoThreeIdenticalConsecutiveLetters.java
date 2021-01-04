package org.exercise;

/**
 * NoThreeIdenticalConsecutiveLetters
 */
public class NoThreeIdenticalConsecutiveLetters {

    /**
     * 
     * @param aOrb
     * @return
     */
    public static int solution(String aOrb) {
        if (aOrb == null) return 0;

        int counter = 0;
        char before = '_';
        char current = '_';
        int returned = 0;
        for (int i = 0; i < aOrb.length(); i++) {
            current = aOrb.charAt(i);
            if (before == current) {
                counter++;
            }
            else {
                counter = 1;
            }
            before = aOrb.charAt(i);

            if (counter == 3) {
                returned++;
                counter = 1;
            }
        }
        
        return returned;
    }

    public static int solutionOnline(String aOrb) {
        int swappingNum = 0;
        for (int i = 0; i < aOrb.length(); i++) {
            int sameLen = 1;
            for (; i + 1 < aOrb.length() && aOrb.charAt(i) == aOrb.charAt(i + 1); i++) {
                sameLen++;
            }
            swappingNum += sameLen / 3;
        }
        return swappingNum;
    }
}