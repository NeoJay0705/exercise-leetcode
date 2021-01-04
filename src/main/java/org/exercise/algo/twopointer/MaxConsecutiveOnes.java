package org.exercise.algo.twopointer;

// 485
// Can opt

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes mc = new MaxConsecutiveOnes();
        int[][] inputs = new int[][]{
                                        new int[]{},
                                        new int[]{0},
                                        new int[]{1},
                                        new int[]{0,0},
                                        new int[]{0,1},
                                        new int[]{1,0},
                                        new int[]{1,1},
                                        new int[]{0,1,0},
                                        new int[]{1,0,1}
                                    };

        for ( int[] input : inputs ) {
            System.out.println(mc.findMaxConsecutiveOnes(input));
        }
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int start = -1;
        for ( int i = 0; i < nums.length; ++i ) {
            if ( i == 0 || (nums[i] ^ nums[i - 1]) != 0 ) {
                if ( nums[i] == 1 ) {
                    start = i;
                }
                else {
                    count = start == -1 ? 0 : Math.max(count, i - start);
                    start = -1;
                }
            }
        }

        int restOne = start == -1 ? 0 : nums.length - start;

        return Math.max(count, restOne);
    }
}
