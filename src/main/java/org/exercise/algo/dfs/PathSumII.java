package org.exercise.algo.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.exercise.zother.inputs.TreeNode;

// 113

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new LinkedList<>(), root, 0, targetSum);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> cands, TreeNode next, int beforeSum, int targetSum) {
        if ( next ==null ) return;

        cands.add(next.val);
        beforeSum += next.val;

        if ( next.left == null && next.right == null && beforeSum == targetSum ) {
            List<Integer> sol = new ArrayList<>();
            sol.addAll(cands);
            result.add(sol);
        }

        helper(result, cands, next.left, beforeSum, targetSum);
        helper(result, cands, next.right, beforeSum, targetSum);

        cands.remove(cands.size() - 1);
    }
}
