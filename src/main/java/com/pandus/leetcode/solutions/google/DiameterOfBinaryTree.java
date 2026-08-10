package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class DiameterOfBinaryTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.getLeft());
        int right = dfs(node.getRight());

        ans = Math.max(ans, left + right);

        return Math.max(left, right) + 1;
    }
}
