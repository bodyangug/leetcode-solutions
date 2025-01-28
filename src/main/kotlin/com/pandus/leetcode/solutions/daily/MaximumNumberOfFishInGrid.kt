package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-number-of-fish-in-a-grid
class MaximumNumberOfFishInGrid {
    private val directions = arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

    fun findMaxFish(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var maxFish = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] > 0) {
                    maxFish = max(maxFish, dfs(n, m, i, j, grid))
                }
            }
        }
        return maxFish
    }

    private fun dfs(n: Int, m: Int, y: Int, x: Int, grid: Array<IntArray>): Int {
        val stack = mutableListOf(Pair(y, x))
        var totalFish = 0

        while (stack.isNotEmpty()) {
            val (cy, cx) = stack.removeAt(stack.size - 1)
            if (cy !in 0 until m || cx !in 0 until n || grid[cy][cx] == 0) {
                continue
            }

            totalFish += grid[cy][cx]
            grid[cy][cx] = 0

            for ((dy, dx) in directions) {
                stack.add(Pair(cy + dy, cx + dx))
            }
        }
        return totalFish
    }
}
