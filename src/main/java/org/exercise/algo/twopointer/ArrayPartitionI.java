package org.exercise.algo.twopointer;

import java.util.Arrays;

// 561
// Can use two pointer?

public class ArrayPartitionI {
    public static void main(String[] args) {
        ArrayPartitionI api = new ArrayPartitionI();
        int[][] inputs = new int[][] { 
                                        {1,1},
                                        {1,2},
                                        {1,1,1,1},
                                        {1,1,1,2},
                                        {1,1,2,2},
                                        {1,2,2,2},
                                        {1,2,2,3},
                                        {1,2,3,3},
                                        {1,2,3,4}
                                     };
        for ( int i = 0; i < inputs.length; ++i) {
            System.out.println(api.arrayPairSum(inputs[i]));
        }

    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for ( int i = nums.length - 1; i > 0; i -= 2 ) {
            sum += nums[i - 1];
        }

        return sum;
    }
}
