package org.exercise;

import java.util.Arrays;

public class MinStepstoMakePilesEqualHeight {
    public static int solution(int[] p) {
        Arrays.sort(p);

        int result = 0;

        for (int i = 0; i + 1 < p.length; i++) {
            if (p[i] == p[i + 1]) continue;

            result += i + 1;
        }



        return 0;
    }
}
