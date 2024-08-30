package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import kotlin.math.max

// Reference: https://leetcode.com/problems/diameter-of-binary-tree
class DiameterOfBinaryTree {

    private var ans = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return ans
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val left = dfs(node.left)
        val right = dfs(node.right)

        ans = max(ans, left + right)

        return max(left, right) + 1
    }
}
