package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level
class MinimumNumberOfOperationsToSortBinaryTreeByLevel {
    fun minimumOperations(root: TreeNode?): Int {
        val q = ArrayDeque(listOf(root ?: return 0))
        var res = 0
        while (q.size > 0) {
            val s = ArrayList<Int>()
            repeat(q.size) {
                val n = q.removeFirst(); s += n.`val`
                n.left?.let { q += it }; n.right?.let { q += it }
            }
            val ix = s.indices.sortedBy { s[it] }.toIntArray()
            for (i in ix.indices) while (ix[i] != i) {
                ix[i] = ix[ix[i]].also { ix[ix[i]] = ix[i] }; res++
            }
        }
        return res
    }
}
