package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y
class CountSubmatricesWithEqualFrequencyOfXAndY {
    fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val prefixX = Array(m) { IntArray(n) }
        val prefixY = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                val x = if (grid[i][j] == 'X') 1 else 0
                val y = if (grid[i][j] == 'Y') 1 else 0
                val top = if (i > 0) 1 else 0
                val left = if (j > 0) 1 else 0
                val topLeft = if (i > 0 && j > 0) 1 else 0

                prefixX[i][j] = x + prefixX[i - top][j] * top +
                    prefixX[i][j - left] * left - prefixX[i - top][j - left] * topLeft
                prefixY[i][j] = y + prefixY[i - top][j] * top +
                    prefixY[i][j - left] * left - prefixY[i - top][j - left] * topLeft
            }
        }

        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (prefixX[i][j] > 0 && prefixX[i][j] == prefixY[i][j]) {
                    count++
                }
            }
        }
        return count
    }
}
