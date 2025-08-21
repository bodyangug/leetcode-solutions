package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/count-submatrices-with-all-ones
class CountSubmatricesWithAllOnes {
    fun numSubmat(mat: Array<IntArray>): Int {
        val m = mat.size
        if (m == 0) return 0
        val n = mat[0].size

        // left[i][j] = number of consecutive 1s ending at (i, j) going leftward in row i
        val left = Array(m) { IntArray(n) }

        // 1) Precompute row-wise widths
        for (i in 0 until m) {
            var run = 0
            for (j in 0 until n) {
                run = if (mat[i][j] == 0) 0 else run + 1
                left[i][j] = run
            }
        }

        // 2) For each cell (i, j), walk upward, tightening min width
        var total = 0L
        for (i in 0 until m) {
            for (j in 0 until n) {
                var minWidth = Int.MAX_VALUE
                var k = i
                while (k >= 0 && left[k][j] > 0) {
                    minWidth = min(minWidth, left[k][j])
                    total += minWidth
                    k--
                }
            }
        }

        return total.toInt()
    }
}
