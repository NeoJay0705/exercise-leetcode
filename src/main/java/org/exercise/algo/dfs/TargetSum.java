package org.exercise.algo.dfs;

import org.exercise.inputs.IntArrInt;

// 494
// Can improve 10%

public class TargetSum {
    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        IntArrInt[] inputs = new IntArrInt[]{
                                                new IntArrInt(new int[]{1,1,1,1,1}, -5), // ----- 1
                                                new IntArrInt(new int[]{1,1,1,1,1}, -3),  // ----+ 5 
                                                new IntArrInt(new int[]{1,1,1,1,1}, -1), // ---++ 10
                                                new IntArrInt(new int[]{1,1,1,1,1}, 1), // --+++ 10
                                                new IntArrInt(new int[]{1,1,1,1,1}, 3), // -++++ 5 
                                                new IntArrInt(new int[]{1,1,1,1,1}, 5), // +++++ 1
                                            };
        for ( IntArrInt input : inputs ) {
            System.out.println(ts.findTargetSumWays(input.nums, input.val));
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, 0, S);
    }

    public int dfs(int[] nums, int index, int sum, int target) {
        if ( index == nums.length ) {
            if ( sum == target ) return 1;
            return 0;
        }
        return dfs(nums, index + 1, sum + nums[index], target) + dfs(nums, index + 1, sum - nums[index], target);
    }
}
