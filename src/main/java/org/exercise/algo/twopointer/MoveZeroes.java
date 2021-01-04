package org.exercise.algo.twopointer;

// 283

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[][] inputs = new int[][] {
                                        new int[]{},
                                        new int[]{0,0,0,1,2},
                                        new int[]{0,0,0,0,0},
                                        new int[]{1,2,3,0,0},
                                        new int[]{1,2,3,4,5},
                                        new int[]{0,0,1,2,0},
                                        new int[]{1,2,0,0,4},
                                     };
        for ( int[] input : inputs ) {
            mz.moveZeroes(input);
            for ( int i : input ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        for ( ; fast < nums.length; ++fast ) {
            if ( nums[fast] != 0) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
        }
    }
}
