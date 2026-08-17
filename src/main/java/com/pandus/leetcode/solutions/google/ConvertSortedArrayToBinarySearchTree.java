package com.pandus.leetcode.solutions.google;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, low, mid - 1);
        root.right = dfs(nums, mid + 1, high);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}