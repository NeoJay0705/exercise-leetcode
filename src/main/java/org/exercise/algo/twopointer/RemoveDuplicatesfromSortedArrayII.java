package org.exercise.algo.twopointer;

// 80

public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII r = new RemoveDuplicatesfromSortedArrayII();
        int[][] inputs = new int[][] {
            {1,1,1,2,2,3}
        };

        for ( int[] input : inputs ) {
            int index = r.removeDuplicates(input);
            System.out.print(index + ": ");
            for ( int i = 0; i <= index; ++i ) {
                System.out.print(input[i] + " ");
            }
            System.out.println();
        }
    }

    public int removeDuplicates(int[] nums) {
        if ( nums.length < 3 ) return nums.length;

        int swapedIndex = 2;
        int preTwoVal = nums[0];

        for ( int i = 2; i < nums.length; ++i ) {
            if ( nums[i] != preTwoVal ) {
                preTwoVal = nums[i - 1];
                nums[swapedIndex] = nums[i];
                swapedIndex++;
            }
            else {
                preTwoVal = nums[i - 1];
            }
        }

        return swapedIndex;
    }
}
