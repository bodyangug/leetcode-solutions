package com.pandus.leetcode.solutions.google;

import com.pandus.leetcode.solutions.model.TreeNode;

public class BinaryTreeMaximumPathSum {
    private int answer;

    public int maxPathSum(TreeNode root) {
        answer = Integer.MIN_VALUE;
        dp(root);
        return answer;
    }

    private int dp(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dp(node.getLeft()));
        int right = Math.max(0, dp(node.getRight()));

        answer = Math.max(answer, node.getVal() + left + right);
        return node.getVal() + Math.max(left, right);
    }
}
