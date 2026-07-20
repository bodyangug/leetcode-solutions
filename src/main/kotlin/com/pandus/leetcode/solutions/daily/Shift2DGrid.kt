package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/shift-2d-grid
class Shift2DGrid {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size
        val n = grid[0].size
        val totalElements = m * n
        val effectiveShifts = k % totalElements

        // Create a new grid to hold the shifted values
        val newGrid = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                // Calculate the new position after shifting
                val newIndex = (i * n + j + effectiveShifts) % totalElements
                val newRow = newIndex / n
                val newCol = newIndex % n
                newGrid[newRow][newCol] = grid[i][j]
            }
        }

        // Convert the new grid to a list of lists and return it
        return newGrid.map { it.toList() }
    }
}
