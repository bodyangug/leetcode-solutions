package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1, root2);
    }

    private boolean check(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        if (tree1.getVal() != tree2.getVal()) return false;

        return (check(tree1.getLeft(), tree2.getRight()) && check(tree1.getRight(), tree2.getLeft())
                || check(tree1.getLeft(), tree2.getLeft()) && check(tree1.getRight(), tree2.getRight()));
    }
}
