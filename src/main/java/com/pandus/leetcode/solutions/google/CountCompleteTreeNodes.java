package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.getLeft());
        int rightDepth = getDepth(root.getRight());

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.getRight());
        } else {
            return (1 << rightDepth) + countNodes(root.getLeft());
        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.getLeft();
        }
        return depth;
    }
}
