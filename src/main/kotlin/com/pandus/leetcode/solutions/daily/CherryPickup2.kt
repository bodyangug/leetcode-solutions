package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/cherry-pickup-ii
class CherryPickup2 {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dpCache = Array(m) {
            Array(n) {
                IntArray(
                    n
                )
            }
        }
        // initial all elements to -1 to mark unseen
        for (i in 0 until m) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    dpCache[i][j][k] = -1
                }
            }
        }
        return dp(0, 0, n - 1, grid, dpCache)
    }

    private fun dp(row: Int, col1: Int, col2: Int, grid: Array<IntArray>, dpCache: Array<Array<IntArray>>): Int {
        if (col1 < 0 || col1 >= grid[0].size || col2 < 0 || col2 >= grid[0].size) {
            return 0
        }
        // check cache
        if (dpCache[row][col1][col2] != -1) {
            return dpCache[row][col1][col2]
        }
        // current cell
        var result = 0
        result += grid[row][col1]
        if (col1 != col2) {
            result += grid[row][col2]
        }
        // transition
        if (row != grid.size - 1) {
            var max = 0
            for (newCol1 in col1 - 1..col1 + 1) {
                for (newCol2 in col2 - 1..col2 + 1) {
                    max = max(max.toDouble(), dp(row + 1, newCol1, newCol2, grid, dpCache).toDouble()).toInt()
                }
            }
            result += max
        }

        dpCache[row][col1][col2] = result
        return result
    }
}
