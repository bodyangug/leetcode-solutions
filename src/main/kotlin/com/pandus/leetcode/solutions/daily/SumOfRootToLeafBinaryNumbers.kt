package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers
class SumOfRootToLeafBinaryNumbers {
    fun sumRootToLeaf(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode?, current: Int): Int {
        if (node == null) return 0
        val next = current shl 1 or node.`val`
        if (node.left == null && node.right == null) return next
        return dfs(node.left, next) + dfs(node.right, next)
    }
}
