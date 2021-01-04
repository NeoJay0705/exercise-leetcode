package org.exercise.algo.twopointer;

// 26

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray rdfsa = new RemoveDuplicatesfromSortedArray();
        int[][] inputs = new int[][] {
                                        new int[]{},
                                        new int[]{0,0,0,0,0},
                                        new int[]{0,0,0,1,2},
                                        new int[]{0,1,2,3,3},
                                        new int[]{0,1,2,3,4},
                                     };
        for ( int[] input : inputs ) {
            System.out.print(rdfsa.removeDuplicates(input) + " ||| ");
            for ( int i : input ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast  = 1;

        for ( ; fast < nums.length; ++fast ) {
            if ( nums[slow] != nums[fast] ) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return nums.length == 0 ? 0 : slow + 1;
    }
}
