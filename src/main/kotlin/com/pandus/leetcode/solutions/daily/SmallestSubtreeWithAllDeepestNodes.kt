package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes
class SmallestSubtreeWithAllDeepestNodes {
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        fun dfs(node: TreeNode?): Pair<TreeNode?, Int> {
            if (node == null) return Pair(null, 0)
            val left = dfs(node.left)
            val right = dfs(node.right)
            return when {
                left.second > right.second -> Pair(left.first, left.second + 1)
                left.second < right.second -> Pair(right.first, right.second + 1)
                else -> Pair(node, left.second + 1)
            }
        }
        return dfs(root).first
    }
}
