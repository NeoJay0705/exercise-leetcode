package org.exercise.algo.twopointer;

import org.exercise.zother.inputs.IntArrInt;

// 209

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
        IntArrInt[] inputs = new IntArrInt[] {
                                                new IntArrInt(new int[]{}, 1),
                                                new IntArrInt(new int[]{1,1}, 2),
                                                new IntArrInt(new int[]{1,2}, 2),
                                                new IntArrInt(new int[]{2,1}, 1),
                                                new IntArrInt(new int[]{2,2}, 2),
                                                new IntArrInt(new int[]{2,2}, 4),
                                                new IntArrInt(new int[]{1}, 1),
                                                new IntArrInt(new int[]{2}, 1),
                                                new IntArrInt(new int[]{1,2,1}, 2),
                                                new IntArrInt(new int[]{1,2,1}, 3),
                                                new IntArrInt(new int[]{2,1,2}, 4),
                                                new IntArrInt(new int[]{1,1,2}, 2),
                                                new IntArrInt(new int[]{2,1,1}, 3),
                                                new IntArrInt(new int[]{11,1,2,3,20,10}, 10),
                                             };
        for ( IntArrInt input : inputs ) {
            System.out.println(msss.minSubArrayLen(input.val, input.nums));
        }
    }

    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        boolean seen = false;
        int sum = 0;
        for ( int low = 0, high = 0; high < nums.length; high++ ) {
            sum += nums[high];
            while ( sum >= s ) {
                len = Math.min(len, high - low + 1);
                sum -= nums[low++];
                seen = true;
            }
        }
        return  !seen ? 0 : len;
    }
}
