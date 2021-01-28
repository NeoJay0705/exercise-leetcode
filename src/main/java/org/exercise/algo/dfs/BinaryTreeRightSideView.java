package org.exercise.algo.dfs;

import java.util.ArrayList;
import java.util.List;
import org.exercise.zother.inputs.TreeNode;

// 199

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0, 0);
        return result;
    }

    public int dfs(TreeNode root, List<Integer> result, int maxLevel, int curLevel) {
        if ( root == null ) return maxLevel;

        curLevel++;
        
        if ( curLevel > maxLevel ) {
            maxLevel =  curLevel;
            result.add(root.val);
        }

        maxLevel = dfs(root.right, result, maxLevel, curLevel);
        maxLevel = dfs(root.left, result, maxLevel, curLevel);
        
        return maxLevel;
    }
}
