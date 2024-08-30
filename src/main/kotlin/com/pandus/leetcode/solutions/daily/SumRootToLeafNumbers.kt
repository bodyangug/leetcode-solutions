package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/sum-root-to-leaf-numbers
class SumRootToLeafNumbers {

    private var rootLeaf = 0

    fun sumNumbers(root: TreeNode?): Int {
        dfs(root, 0)
        return rootLeaf
    }

    private fun dfs(root: TreeNode?, num: Int) {
        var num = num
        if (root != null) {
            num = num * 10 + root.`val`
            if (root.left == null && root.right == null) {
                rootLeaf += num
            }
            dfs(root.left, num)
            dfs(root.right, num)
        }
    }
}
