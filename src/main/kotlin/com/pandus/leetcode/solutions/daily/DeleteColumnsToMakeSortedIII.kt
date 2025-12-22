package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/delete-columns-to-make-sorted-iii
class DeleteColumnsToMakeSortedIII {
    fun minDeletionSize(strs: Array<String>): Int {
        val n = strs.size
        val m = strs[0].length
        val dp = IntArray(m) { 1 }

        for (i in 1 until m) {
            for (j in 0 until i) {
                var canExtend = true
                for (k in 0 until n) {
                    if (strs[k][j] > strs[k][i]) {
                        canExtend = false
                        break
                    }
                }
                if (canExtend) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        val maxSortedColumns = dp.maxOrNull() ?: 0
        return m - maxSortedColumns
    }
}
