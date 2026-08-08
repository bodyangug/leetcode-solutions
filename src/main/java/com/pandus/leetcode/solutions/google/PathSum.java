package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.getLeft() == null && root.getRight() == null) return targetSum == root.getVal();
        return hasPathSum(root.getLeft(), targetSum - root.getVal())
                || hasPathSum(root.getRight(), targetSum - root.getVal());
    }
}
