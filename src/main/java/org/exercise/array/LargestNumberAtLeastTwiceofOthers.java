package org.exercise.array;

// # 747
// Using index instead of storing value of the index

public class LargestNumberAtLeastTwiceofOthers {
    private LargestNumberAtLeastTwiceofOthers() {}
    
    public static int solution1(int[] nums) {
        if (nums.length == 1) return 0;

        int max1 = 0;
        int max2 = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max1]) {
                max2 = max1;
                max1 = i;
            } else {
                if (max2 < 0) max2 = i;
                else if (nums[i] > nums[max2]) max2 = i;
            }
        }

        if (nums[max1] >= 2 * nums[max2]) return max1;

        return -1;
    }
}
