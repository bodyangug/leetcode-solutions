package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

// Reference: https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid
class MinimumTimeToVisitCellInGrid {
    private val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    fun minimumTime(grid: Array<IntArray>): Int {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) { false } }
        visited[0][0] = true
        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
        pq.offer(Triple(0, 0, 0))
        while (pq.isNotEmpty()) {
            val (row, col, currentTime) = pq.poll()!!
            if (row == m - 1 && col == n - 1) return currentTime
            for ((deltaX, deltaY) in directions) {
                val newRow = row + deltaX
                val newCol = col + deltaY
                var newTime = currentTime + 1
                if (newRow in 0 until m && newCol in 0 until n && !visited[newRow][newCol]) {
                    if (newTime < grid[newRow][newCol]) {
                        newTime = grid[newRow][newCol] + (grid[newRow][newCol] - newTime) % 2
                    }
                    visited[newRow][newCol] = true
                    pq.offer(Triple(newRow, newCol, newTime))
                }
            }
        }
        return -1
    }
}
