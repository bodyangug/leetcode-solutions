package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
    }
}
