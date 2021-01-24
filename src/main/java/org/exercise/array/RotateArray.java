package org.exercise.array;

import org.exercise.zother.inputs.IntArrInt;

// 189

public class RotateArray {
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        IntArrInt[] inputs = new IntArrInt[] {
                                                new IntArrInt(new int[]{1,2,3,4,5}, 0),
                                                new IntArrInt(new int[]{1,2,3,4,5}, 1),
                                                new IntArrInt(new int[]{1,2,3,4,5}, 2),
                                                new IntArrInt(new int[]{1,2,3,4,5}, 3),
                                                new IntArrInt(new int[]{1,2,3,4,5}, 4),
                                                new IntArrInt(new int[]{1,2,3,4,5}, 5),
                                                new IntArrInt(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, 3),
                                                new IntArrInt(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21}, 3),
                                             };

        for ( IntArrInt input : inputs ) {
            ra.rotate(input.nums, input.val);
            for ( int i : input.nums ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }    
    }

    public void rotate(int[] nums, int k) {
        int rotatedCount = k % nums.length;

        if ( rotatedCount == 0 ) return;

        int currAtIndex = 0;
        int oldCachedNum = nums[currAtIndex];
        int start = 0;

        for ( int i = 0; i < nums.length; ++i ) {
            int moveToIndex = (currAtIndex + rotatedCount) % nums.length;
            int newCachedNum = nums[moveToIndex];
            nums[moveToIndex] = oldCachedNum;
            oldCachedNum = newCachedNum;
            currAtIndex = moveToIndex;

            if ( currAtIndex == start ) {
                currAtIndex++;
                oldCachedNum = nums[currAtIndex];
                start = currAtIndex;
            }
        }
    }
}
