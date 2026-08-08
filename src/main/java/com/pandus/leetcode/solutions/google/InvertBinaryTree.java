package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);

        invert(node.getLeft());
        invert(node.getRight());
    }
}
