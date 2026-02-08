package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import kotlin.math.abs

// Reference: https://leetcode.com/problems/balanced-binary-tree
class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkBalance(root) != -1
    }

    private fun checkBalance(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = checkBalance(node.left)
        if (leftHeight == -1) return -1

        val rightHeight = checkBalance(node.right)
        if (rightHeight == -1) return -1

        if (abs(leftHeight - rightHeight) > 1) return -1

        return 1 + leftHeight.coerceAtLeast(rightHeight)
    }
}
