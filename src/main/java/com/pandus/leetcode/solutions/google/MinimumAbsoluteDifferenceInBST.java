package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.getLeft());
        if (prev != null) min = Math.min(min, root.getVal() - prev);
        prev = root.getVal();
        inorder(root.getRight());
    }
}
