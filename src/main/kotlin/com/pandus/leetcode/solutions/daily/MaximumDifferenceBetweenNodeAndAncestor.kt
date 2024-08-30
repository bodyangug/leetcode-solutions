package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor
class MaximumDifferenceBetweenNodeAndAncestor {

    fun maxAncestorDiff(root: TreeNode?): Int {
        if (root == null) return 0
        return df(root, root.`val`, root.`val`)
    }

    fun df(curNode: TreeNode?, curMax: Int, curMin: Int): Int {
        if (curNode == null) {
            return curMax - curMin
        }

        val newMax = maxOf(curMax, curNode.`val`)
        val newMin = minOf(curMin, curNode.`val`)

        val left = df(curNode.left, newMax, newMin)
        val right = df(curNode.right, newMax, newMin)
        return maxOf(left, right)
    }
}
