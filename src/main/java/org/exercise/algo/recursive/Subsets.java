package org.exercise.algo.recursive;

import java.util.ArrayList;
import java.util.List;

// 78

public class Subsets {
    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[][] inputs = new int[][] {
            {1,2,3},
            {0},
        };

        for ( int[] input : inputs ) {
            for ( List<Integer> i : s.subsets(input) ) {
                System.out.print("[");
                for ( int j : i ) {
                    System.out.print(j + " ");
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        helper(new ArrayList<>(), 0, nums, result);

        return result;
    }

    public void helper(List<Integer> candidate, int index, int[] nums, List<List<Integer>> result) {
        for ( int i = index; i < nums.length; ++i ) {
            List<Integer> copy = new ArrayList<>(candidate);
            copy.add(nums[i]);
            result.add(copy);
            helper(copy, i + 1, nums, result);
        }
    }
}
