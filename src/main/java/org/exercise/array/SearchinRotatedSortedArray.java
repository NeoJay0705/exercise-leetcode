package org.exercise.array;

// 33

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    public int helper(int[] nums, int target, int start, int end) {
        int mid = ( start + end ) / 2;
        if ( nums[mid] == target ) return mid;
        if ( start == end ) return -1;

        if ( nums[start] <= nums[mid] ) {
            if ( target >= nums[start] && target < nums[mid] ) 
                return helper(nums, target, start, mid - 1);
            else return helper(nums, target, mid + 1, end);
            
        }
        else {
            if ( target > nums[mid] && target <= nums[end] ) 
                return helper(nums, target, mid + 1, end);
            else return helper(nums, target, start, mid - 1);
        }
    }
}
