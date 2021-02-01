package org.exercise.algo.dfs;

import org.exercise.zother.inputs.ListNode;
import org.exercise.zother.inputs.TreeNode;

// 109
// can improve

public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        ListNode tmp = head;
        int len = 0;
        for ( ; tmp != null; ) {
            len++;
            tmp = tmp.next;
        }
        return helper(head, 0, len - 1);
    }

    public TreeNode helper(ListNode head, int start, int end) {
        if ( start > end ) return null;

        int mid = (start + end) / 2;
        ListNode tmp = head;
        for ( int i = start; i < mid; ++i ) {
            tmp = tmp.next;
        }
        TreeNode newNode = new TreeNode(tmp.val);
        newNode.left = helper(head, start, mid - 1);
        newNode.right = helper(tmp.next, mid + 1, end);

        return newNode;
    }
}
