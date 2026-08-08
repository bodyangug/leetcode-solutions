package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root.getLeft(), root.getRight());
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (right == null || left == null) return false;
        if (right.getVal() != left.getVal()) return false;
        return check(left.getLeft(), right.getRight()) && check(left.getRight(), right.getLeft());
    }
}
