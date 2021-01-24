package org.exercise.zother.tbd;

import java.util.HashSet;
import java.util.Set;

public class LargestK {
    public static int solution(int[] nums) {
        int largestK = 0;
        Set<Integer> inputSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            inputSet.add(nums[i]);
            if (inputSet.contains(-nums[i])) {
                largestK = Math.max(largestK, Math.abs(nums[i]));
            }
        }

        return largestK;
    }
}
