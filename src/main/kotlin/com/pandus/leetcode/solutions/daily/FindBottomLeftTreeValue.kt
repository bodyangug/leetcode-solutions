package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/find-bottom-left-tree-value
class FindBottomLeftTreeValue {
    private var ans = 0
    private var maxDepth = -1
    fun findBottomLeftValue(root: TreeNode?): Int {
        root?.let {
            dfs(it, 0)
        }
        return ans
    }

    private fun dfs(root: TreeNode?, depth: Int) {
        root?.let {
            if (depth > maxDepth) {
                maxDepth = depth.also { ans = root.`val` }
            }
            dfs(root.left, depth + 1)
            dfs(root.right, depth + 1)
        }
    }
}
