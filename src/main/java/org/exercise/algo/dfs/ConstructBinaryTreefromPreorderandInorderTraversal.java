package org.exercise.algo.dfs;

import java.util.HashMap;
import java.util.Map;
import org.exercise.zother.inputs.TreeNode;

// 105

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal cb = new ConstructBinaryTreefromPreorderandInorderTraversal();
        cb.buildTree(new int[]{1,2,3}, new int[]{2,1,3});    
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ( preorder.length == 0 ) return null;

        TreeNode root = new TreeNode(preorder[0]);

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for ( int i = 0; i < inorder.length; ++i ) {
            inorderMap.put(inorder[i], i);
        }

        helper(preorder, 1, root, inorder.length - 1, inorderMap);

        return root;
    }

    public int helper(int[] preorder, int nextIndex, TreeNode root, int parentOrder, Map<Integer, Integer> inorderMap) {
        if ( preorder.length == nextIndex ) return -1;

        TreeNode nextNode = new TreeNode(preorder[nextIndex]);
        if ( inorderMap.get(nextNode.val) < inorderMap.get(root.val) ) {
            root.left = nextNode;
            nextIndex = helper(preorder, nextIndex + 1, nextNode, inorderMap.get(root.val), inorderMap);
        }
        
        
        if ( nextIndex != -1 ) {
            nextNode = new TreeNode(preorder[nextIndex]);
            if( inorderMap.get(nextNode.val) <= parentOrder ) {
                root.right = nextNode;
                nextIndex = helper(preorder, nextIndex + 1, nextNode, parentOrder, inorderMap);
            }
        }
        
        return nextIndex;
    }
}
