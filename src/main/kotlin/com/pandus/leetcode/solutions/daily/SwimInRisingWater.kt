package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/swim-in-rising-water
class SwimInRisingWater {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        var left = grid[0][0]
        var right = 0

        // Find the maximum elevation to set upper bound for binary search
        for (row in grid) {
            for (height in row) {
                right = maxOf(right, height)
            }
        }

        while (left < right) {
            val mid = left + (right - left) / 2
            if (canReach(grid, mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun canReach(grid: Array<IntArray>, timeLimit: Int): Boolean {
        val n = grid.size
        if (grid[0][0] > timeLimit) return false

        val visited = Array(n) { BooleanArray(n) }
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        return dfs(grid, 0, 0, timeLimit, visited, directions)
    }

    private fun dfs(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        timeLimit: Int,
        visited: Array<BooleanArray>,
        directions: Array<IntArray>
    ): Boolean {
        val n = grid.size

        if (row == n - 1 && col == n - 1) return true

        visited[row][col] = true

        for (dir in directions) {
            val newRow = row + dir[0]
            val newCol = col + dir[1]

            if (newRow in 0 until n && newCol in 0 until n &&
                !visited[newRow][newCol] && grid[newRow][newCol] <= timeLimit
            ) {
                if (dfs(grid, newRow, newCol, timeLimit, visited, directions)) {
                    return true
                }
            }
        }

        return false
    }
}
