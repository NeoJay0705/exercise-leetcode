package org.exercise.appdata.tree;

import java.util.Deque;
import java.util.LinkedList;

import org.exercise.inputs.TreeNode;

// 101

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root.left);
        queue.offerLast(root.right);

        while ( !queue.isEmpty() ) {
            TreeNode ft = queue.pollFirst();
            TreeNode sec = queue.pollFirst();
            if ( ft == null && sec == null ) continue;
            if ( ft != null && sec != null ) {
                if ( ft.val == sec.val ) {
                    queue.offerLast(ft.left);
                    queue.offerLast(sec.right);
                    queue.offerLast(ft.right);
                    queue.offerLast(sec.left);
                    continue;
                }
                return false;
            } 
            return false;
        }

        return true;
    }

    public boolean isSymmetric_re(TreeNode root) {
        if ( root == null ) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode ft, TreeNode sec) {
        if ( ft == null && sec == null ) return true;
        if ( ft != null && sec != null ) {
            if ( ft.val == sec.val ) {
                return dfs(ft.left, sec.right) && dfs(ft.right, sec.left);
            }
            return false;
        } 
        return false;
    }
}
