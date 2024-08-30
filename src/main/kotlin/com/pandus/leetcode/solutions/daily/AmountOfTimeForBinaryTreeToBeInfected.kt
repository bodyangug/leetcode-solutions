package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import kotlin.math.abs

// Reference: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected
class AmountOfTimeForBinaryTreeToBeInfected {
    private var maxDistance = 0
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        traverse(root, start)
        return maxDistance
    }

    private fun traverse(root: TreeNode?, start: Int): Int {
        var depth = 0
        if (root == null) {
            return depth
        }

        val leftDepth = traverse(root.left, start)
        val rightDepth = traverse(root.right, start)

        if (root.`val` == start) {
            maxDistance = leftDepth.coerceAtLeast(rightDepth)
            depth = -1
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = leftDepth.coerceAtLeast(rightDepth) + 1
        } else {
            var distance = abs(leftDepth) + abs(rightDepth)
            maxDistance = maxDistance.coerceAtLeast(distance)
            depth = leftDepth.coerceAtMost(rightDepth) - 1
        }
        return depth
    }
}
