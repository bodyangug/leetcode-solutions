package com.pandus.leetcode.solutions.daily

import java.util.LinkedList
import java.util.Queue

// Reference: https://leetcode.com/problems/find-the-safest-path-in-a-grid
class FindTheSafestPathInGrid {

    private val directions = arrayOf(
        intArrayOf(0, 1), // right
        intArrayOf(0, -1), // left
        intArrayOf(1, 0), // down
        intArrayOf(-1, 0) // up
    )

    fun maximumSafenessFactor(grid: List<List<Int>>): Int {
        val n = grid.size
        val mat = Array(n) { IntArray(n) { -1 } }
        val queue: Queue<IntArray> = LinkedList()

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    queue.add(intArrayOf(i, j))
                    mat[i][j] = 0
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (i, j) = queue.poll()
            val currentValue = mat[i][j]
            for ((di, dj) in directions) {
                val ni = i + di
                val nj = j + dj
                if (isValidCell(mat, ni, nj) && mat[ni][nj] == -1) {
                    mat[ni][nj] = currentValue + 1
                    queue.add(intArrayOf(ni, nj))
                }
            }
        }

        var start = 0
        var end = mat.maxOf { row -> row.maxOrNull() ?: 0 }
        var result = -1

        while (start <= end) {
            val mid = (start + end) / 2
            if (isValidSafeness(mat, mid)) {
                result = mid
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return result
    }

    private fun isValidSafeness(grid: Array<IntArray>, minSafeness: Int): Boolean {
        val n = grid.size
        if (grid[0][0] < minSafeness || grid[n - 1][n - 1] < minSafeness) return false

        val queue: Queue<IntArray> = LinkedList()
        queue.add(intArrayOf(0, 0))
        val visited = Array(n) { BooleanArray(n) }
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val (i, j) = queue.poll()
            if (i == n - 1 && j == n - 1) return true

            for ((di, dj) in directions) {
                val ni = i + di
                val nj = j + dj
                if (isValidCell(grid, ni, nj) && !visited[ni][nj] && grid[ni][nj] >= minSafeness) {
                    visited[ni][nj] = true
                    queue.add(intArrayOf(ni, nj))
                }
            }
        }
        return false
    }

    private fun isValidCell(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return i in grid.indices && j in grid[i].indices
    }
}
