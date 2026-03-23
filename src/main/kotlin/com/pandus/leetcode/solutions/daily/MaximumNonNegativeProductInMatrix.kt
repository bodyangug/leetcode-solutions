package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix
class MaximumNonNegativeProductInMatrix {
    fun maxProductPath(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val maxProduct = Array(m) { LongArray(n) }
        val minProduct = Array(m) { LongArray(n) }
        maxProduct[0][0] = grid[0][0].toLong()
        minProduct[0][0] = grid[0][0].toLong()

        for (i in 1 until m) {
            maxProduct[i][0] = maxProduct[i - 1][0] * grid[i][0]
            minProduct[i][0] = maxProduct[i][0]
        }

        for (j in 1 until n) {
            maxProduct[0][j] = maxProduct[0][j - 1] * grid[0][j]
            minProduct[0][j] = maxProduct[0][j]
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                val currentValue = grid[i][j].toLong()
                if (currentValue >= 0) {
                    maxProduct[i][j] = maxProduct[i - 1][j].coerceAtLeast(maxProduct[i][j - 1]) * currentValue
                    minProduct[i][j] = minProduct[i - 1][j].coerceAtMost(minProduct[i][j - 1]) * currentValue
                } else {
                    maxProduct[i][j] = minProduct[i - 1][j].coerceAtMost(minProduct[i][j - 1]) * currentValue
                    minProduct[i][j] = maxProduct[i - 1][j].coerceAtLeast(maxProduct[i][j - 1]) * currentValue
                }
            }
        }
        return if (maxProduct[m - 1][n - 1] < 0) -1 else (maxProduct[m - 1][n - 1] % 1000000007).toInt()
    }
}
