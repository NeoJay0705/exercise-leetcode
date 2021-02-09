package org.exercise.algo.recursive;

// 34

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1, new int[]{-1, -1});
    }

    public int[] bs(int[] nums, int target, int start, int end, int[] result) {
        if ( start > end ) return result;

        int mid = ( start + end ) / 2;
        int currIndex = nums[mid] == target ? mid : -1;
        
        if ( currIndex == -1 ) {
            if ( target < nums[mid]) return bs(nums, target, start, mid - 1, result);
            else return bs(nums, target, mid + 1, end, result);
        }
        else {
            result[0] = result[0] != -1 ? Math.min(result[0], currIndex) : currIndex;
            result[1] = Math.max(result[1], currIndex);

            bs(nums, target, start, mid - 1, result);
            bs(nums, target, mid + 1, end, result);
        }

        return result;
    }
}
