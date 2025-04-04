package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
class LowestCommonAncestorOfDeepestLeaves {
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        return dfs(root).first
    }

    private fun dfs(root: TreeNode?): Pair<TreeNode?, Int> {
        if (root == null) {
            return Pair(null, 0)
        }

        val (leftNode, leftDepth) = dfs(root.left)
        val (rightNode, rightDepth) = dfs(root.right)

        return when {
            leftDepth > rightDepth -> Pair(leftNode, leftDepth + 1)
            leftDepth < rightDepth -> Pair(rightNode, rightDepth + 1)
            else -> Pair(root, leftDepth + 1)
        }
    }
}
