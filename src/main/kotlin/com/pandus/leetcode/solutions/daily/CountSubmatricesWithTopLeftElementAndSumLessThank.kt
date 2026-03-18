package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k
class CountSubmatricesWithTopLeftElementAndSumLessThank {
    fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val prefix = Array(m) { IntArray(n) }
        var count = 0

        for (i in 0..<m) {
            for (j in 0..<n) {
                prefix[i][j] = grid[i][j] +
                    (if (i > 0) prefix[i - 1][j] else 0) +
                    (if (j > 0) prefix[i][j - 1] else 0) -
                    (if (i > 0 && j > 0) prefix[i - 1][j - 1] else 0)
                if (prefix[i][j] <= k) count++
            }
        }
        return count
    }
}
