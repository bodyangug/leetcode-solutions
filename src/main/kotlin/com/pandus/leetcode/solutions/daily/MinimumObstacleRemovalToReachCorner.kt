package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner
class MinimumObstacleRemovalToReachCorner {
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val distances = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        distances[0][0] = 0

        val pq = PriorityQueue<IntArray>(compareBy { it[2] })
        pq.offer(intArrayOf(0, 0, 0))

        while (pq.isNotEmpty()) {
            val (row, col, obstacles) = pq.poll()

            if (obstacles > distances[row][col]) continue
            if (row == m - 1 && col == n - 1) return obstacles

            for (dir in directions) {
                val newRow = row + dir[0]
                val newCol = col + dir[1]

                if (newRow in 0 until m && newCol in 0 until n) {
                    val newObstacles = obstacles + grid[newRow][newCol]
                    if (newObstacles < distances[newRow][newCol]) {
                        distances[newRow][newCol] = newObstacles
                        pq.offer(intArrayOf(newRow, newCol, newObstacles))
                    }
                }
            }
        }
        return distances[m - 1][n - 1]
    }
}
