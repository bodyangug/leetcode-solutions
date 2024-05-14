package com.pandus.leetcode.solutions.daily

import kotlin.math.max

//Reference: https://leetcode.com/problems/path-with-maximum-gold
class PathWithMaximumGold {
    private val DIRECTIONS = intArrayOf(0, 1, 0, -1, 0)

    fun getMaximumGold(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var maxGold = 0

        // Search for the path with the maximum gold starting from each cell
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                maxGold = max(maxGold.toDouble(), dfsBacktrack(grid, rows, cols, row, col).toDouble()).toInt()
            }
        }
        return maxGold
    }

    private fun dfsBacktrack(grid: Array<IntArray>, rows: Int, cols: Int, row: Int, col: Int): Int {
        // Base case: this cell is not in the matrix or this cell has no gold
        if (row < 0 || col < 0 || row == rows || col == cols || grid[row][col] == 0) {
            return 0
        }
        var maxGold = 0

        // Mark the cell as visited and save the value
        val originalVal = grid[row][col]
        grid[row][col] = 0

        // Backtrack in each of the four directions
        for (direction in 0..3) {
            maxGold = max(
                maxGold.toDouble(),
                dfsBacktrack(
                    grid, rows, cols, DIRECTIONS[direction] + row,
                    DIRECTIONS[direction + 1] + col
                ).toDouble()
            ).toInt()
        }

        // Set the cell back to its original value
        grid[row][col] = originalVal
        return maxGold + originalVal
    }
}