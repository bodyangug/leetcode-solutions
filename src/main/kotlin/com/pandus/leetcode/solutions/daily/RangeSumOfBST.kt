package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Refrence: https://leetcode.com/problems/range-sum-of-bst
class RangeSumOfBST {
    private var result = 0
    private var low = 0
    private var high = 0
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        this.low = low
        this.high = high
        iterateLeaves(root)
        return result
    }

    private fun iterateLeaves(node: TreeNode?) {
        if (node != null) {
            if (node.`val` in low..high) {
                result += node.`val`
            }
            if (node.`val` > low) {
                iterateLeaves(node.left)
            }
            if (node.`val` < high) {
                iterateLeaves(node.right)
            }
        }
    }
}
