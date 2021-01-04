package org.exercise.array;

// #724
// Sum of all numbers before a for-loop

public class FindPivotIndex {
    private FindPivotIndex() {};

    public static int solution1(int[] nums) {
        int pivot = -1;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                sum -= nums[j];
            }

            if (sum == 0) {
                pivot = i;
                break;
            }
        }
        
        return pivot;
    }

    public static int solution2(int[] nums) {
        int pivot = -1;
        
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (i > 0) left += nums[i - 1];

            if (left == right) {
                pivot = i;
                break;
            }
        }

        return pivot;
    }
}
