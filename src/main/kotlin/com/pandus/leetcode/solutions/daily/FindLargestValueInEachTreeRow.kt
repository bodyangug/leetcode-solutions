package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import kotlin.math.max

// Reference: https://leetcode.com/problems/find-largest-value-in-each-tree-row
class FindLargestValueInEachTreeRow {
    fun largestValues(root: TreeNode?): List<Int> = buildList {
        fun dfs(n: TreeNode?, d: Int): Unit = n?.run {
            if (d < size) {
                set(d, max(get(d), `val`))
            } else {
                add(`val`)
            }
            dfs(left, d + 1)
            dfs(right, d + 1)
        } ?: Unit
        dfs(root, 0)
    }
}
