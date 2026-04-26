package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/detect-cycles-in-2d-grid
class DetectCyclesIn2DGrid {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun dfs(grid: Array<CharArray>, visited: Array<BooleanArray>, i: Int, j: Int, x: Int, y: Int): Boolean {
        if (visited[i][j]) {
            return true
        }
        visited[i][j] = true
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        for (dir in directions) {
            val newX = i + dir[0]
            val newY = j + dir[1]
            if (newX >= 0 && newX < grid.size && newY >= 0 && newY < grid[0].size && grid[newX][newY] == grid[i][j]) {
                if (newX != x || newY != y) {
                    if (dfs(grid, visited, newX, newY, i, j)) {
                        return true
                    }
                }
            }
        }
        return false
    }
}
