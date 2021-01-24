package org.exercise.tree;

import org.exercise.zother.inputs.TreeNode;

// 108

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int lindex, int rindex) {
        if ( rindex < lindex ) return null;

        int midIndex = (lindex + rindex) / 2;
        TreeNode newRoot = new TreeNode(nums[midIndex]);
        newRoot.left = helper(nums, lindex, midIndex - 1);
        newRoot.right = helper(nums, midIndex + 1, rindex);

        return newRoot;
    }
}
