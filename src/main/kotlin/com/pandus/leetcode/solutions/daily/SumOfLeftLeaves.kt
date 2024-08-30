package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/sum-of-left-leaves
class SumOfLeftLeaves {
    private var ans = 0

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        dfs(root, false)
        return ans
    }

    private fun dfs(root: TreeNode?, isLeft: Boolean) {
        root?.let {
            val left = it.left
            val right = it.right

            if (isLeft && left == null && right == null) {
                ans += it.`val`
            }
            dfs(left, true)
            dfs(right, false)
        }
    }
}
