package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island
class MinimumNumberOfDaysToDisconnectIsland {
    // Directions for adjacent cells: right, left, down, up
    private val directions: Array<IntArray> = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
    )

    fun minDays(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        // Count initial islands
        val initialIslandCount = countIslands(grid)

        // Already disconnected or no land
        if (initialIslandCount != 1) {
            return 0
        }

        // Try removing each land cell
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == 0) continue // Skip water

                // Temporarily change to water
                grid[row][col] = 0
                val newIslandCount = countIslands(grid)

                // Check if disconnected
                if (newIslandCount != 1) return 1

                // Revert change
                grid[row][col] = 1
            }
        }

        return 2
    }

    private fun countIslands(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val visited = Array(rows) { BooleanArray(cols) }
        var islandCount = 0

        // Iterate through all cells
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                // Found new island
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited)
                    islandCount++
                }
            }
        }
        return islandCount
    }

    // Helper method to explore all cells of an island
    private fun exploreIsland(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        visited: Array<BooleanArray>
    ) {
        visited[row][col] = true

        // Check all adjacent cells
        for (direction in directions) {
            val newRow = row + direction[0]
            val newCol = col + direction[1]
            // Explore if valid land cell
            if (isValidLandCell(grid, newRow, newCol, visited)) {
                exploreIsland(grid, newRow, newCol, visited)
            }
        }
    }

    private fun isValidLandCell(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        visited: Array<BooleanArray>
    ): Boolean {
        val rows = grid.size
        val cols = grid[0].size
        // Check bounds, land, and not visited
        return (row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] == 1 && !visited[row][col])
    }
}
