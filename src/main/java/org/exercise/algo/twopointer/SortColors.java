package org.exercise.algo.twopointer;

// 75

public class SortColors {
    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[][] inputs = new int[][] {
            {0},
            {1},
            {2},
            {0,0,1,1,2,2},
            {1,1,0,0,2,2},
            {2,2,1,1,0,0},
            {2,2,0,0,1,1},
            {0,0,2,2,1,1},
            {1,1,2,2,0,0},
            {1,1,1},
            {0,0,0},
            {2,2,2},
            {1,0},
            {2,0,2,1,1,0}
        };

        for ( int[] input : inputs ) {
            sc.sortColors(input);
            for ( int i : input ) System.out.print(i + " ");
            System.out.println();
        }
    }

    public void sortColors(int[] nums) {
        int head = 0; 
        int mid = 0;
        int tail = nums.length - 1;
        int tmp;

        while ( mid < nums.length && mid <= tail ) {
            if ( nums[mid] == 0 ) {
                tmp = nums[head];
                nums[head] = nums[mid];
                nums[mid] = tmp;
                head++;
                mid++;
            }
            else if ( nums[mid] == 1 ) {
                mid++;
            }
            else {
                tmp = nums[tail];
                nums[tail] = nums[mid];
                nums[mid] = tmp;
                tail--;
            }
        }
    }
}
