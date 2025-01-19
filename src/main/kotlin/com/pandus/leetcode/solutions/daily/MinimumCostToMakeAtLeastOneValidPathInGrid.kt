package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid
class MinimumCostToMakeAtLeastOneValidPathInGrid {
    fun minCost(grid: Array<IntArray>): Int {
        val q = ArrayDeque<IntArray>()
        q += intArrayOf(0, 0, 0)
        val d = listOf(0, 1, 0, -1, 1, 0, -1, 0)
        while (q.size > 0) {
            val (c, y, x) = q.removeFirst()
            if (y == grid.lastIndex && x == grid[0].lastIndex) return c
            if ((grid.getOrNull(y)?.getOrNull(x) ?: 0) < 1) continue
            val curr = grid[y][x]
            grid[y][x] = 0
            for (i in 0..3) if (i + 1 == curr)
                q.addFirst(intArrayOf(c, y + d[2 * i], x + d[2 * i + 1]))
            else q += intArrayOf(c + 1, y + d[2 * i], x + d[2 * i + 1])
        }
        return -1
    }
}
