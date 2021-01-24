package org.exercise.algo.twopointer;

import org.exercise.zother.inputs.IntArrInt;

// 27

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        IntArrInt[] inputs = new IntArrInt[] {
                                                new IntArrInt(new int[]{1,2,3,4}, 1),
                                                new IntArrInt(new int[]{1,2,3,4}, 3),
                                                new IntArrInt(new int[]{1,2,3,4}, 4),
                                                new IntArrInt(new int[]{1,1,3,4}, 1),
                                                new IntArrInt(new int[]{1,2,1,4}, 1),
                                                new IntArrInt(new int[]{1,2,3,1}, 1),   
                                                new IntArrInt(new int[]{0,1,1,4}, 1),
                                                new IntArrInt(new int[]{0,1,2,1}, 1),
                                                new IntArrInt(new int[]{0,0,1,1}, 1),
                                                new IntArrInt(new int[]{}, 1),     
                                                new IntArrInt(new int[]{1}, 1),   
                                                new IntArrInt(new int[]{1,1}, 1),    
                                                new IntArrInt(new int[]{1,2}, 1),
                                             };
        for ( IntArrInt input : inputs ) {
            int len = re.removeElement(input.nums, input.val);
            System.out.print(len + ": ");
            for ( int i : input.nums ) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    public int removeElement(int[] nums, int val) {
        int len = 0;
        for ( int i = 0; i < nums.length; ++i ) {
            if ( nums[i] != val ) {
                nums[len] = nums[i];
                len++;
            }
        }

        return len;
    }
}
