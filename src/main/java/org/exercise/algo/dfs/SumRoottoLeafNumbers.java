package org.exercise.algo.dfs;

import java.util.ArrayList;
import java.util.List;

import org.exercise.zother.inputs.TreeNode;

// 129

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        // return helper(root, new ArrayList<>());
        return helper_rec(root, 0);
    }

    public int helper(TreeNode root, List<Integer> digits) {
        if ( root == null ) return 0;

        if ( root.left == null && root.right == null ) {
            digits.add(0);
            return root.val;
        }

        List<Integer> childDigits = new ArrayList<>();

        int childSum = helper(root.left, childDigits) + helper(root.right, childDigits);

        for ( Integer i : childDigits ) {
            digits.add(i + 1);
            childSum += root.val * Math.pow(10, i + 1);
        }

        return childSum;
    }

    public int helper_rec(TreeNode root, int cur) {
        if ( root == null ) return 0;
        cur = root.val + cur * 10;
        if ( root.left == null && root.right == null ) return cur;
        return helper_rec(root.left, cur) + helper_rec(root.right, cur);
    }
}
