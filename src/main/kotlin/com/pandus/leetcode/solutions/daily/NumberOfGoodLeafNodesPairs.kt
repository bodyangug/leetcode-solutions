package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/number-of-good-leaf-nodes-pairs
class NumberOfGoodLeafNodesPairs {
    private var ans = 0
    private var distance: Int = -1

    fun countPairs(root: TreeNode?, distance: Int): Int {
        this.distance = distance
        dfs(root)
        return ans
    }

    private fun dfs(node: TreeNode?): List<Int> {
        if (node == null) return emptyList()
        if (node.left == null && node.right == null) return listOf(0)

        val leftDistances = dfs(node.left)
        val rightDistances = dfs(node.right)

        for (l in leftDistances) {
            for (r in rightDistances) {
                if (l + r + 2 <= distance) {
                    ans++
                }
            }
        }
        return (leftDistances + rightDistances).map { it + 1 }
    }
}
