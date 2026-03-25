package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/equal-sum-grid-partition-i
class EqualSumGridPartitionI {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val total = grid.sumOf { row -> row.sumOf { it.toLong() } }

        if (total and 1L == 1L) return false

        val target = total / 2
        var sum = 0L

        for (i in 0 until m - 1) {
            for (j in 0 until n) sum += grid[i][j]
            if (sum == target) return true
        }

        sum = 0L

        for (j in 0 until n - 1) {
            for (i in 0 until m) sum += grid[i][j]
            if (sum == target) return true
        }
        return false
    }
}
