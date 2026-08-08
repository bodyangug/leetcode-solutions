package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        flatten(root.getLeft());
        flatten(root.getRight());
        root.setLeft(null);
        root.setRight(left);

        TreeNode pointer = root;
        while (pointer.getRight() != null){
            pointer = pointer.getRight();
        }
        pointer.setRight(right);
    }
}
