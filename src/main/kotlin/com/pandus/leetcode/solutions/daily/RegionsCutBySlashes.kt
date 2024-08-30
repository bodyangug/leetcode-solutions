package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/regions-cut-by-slashes
class RegionsCutBySlashes {
    fun regionsBySlashes(grid: Array<String>): Int {
        val n = grid.size
        // 3n x 3n grid to represent each cell in the original grid as a 3x3 block
        val expandedGrid = Array(n * 3) { BooleanArray(n * 3) }

        // Marking the cells in the 3x3 grid
        for (i in 0 until n) {
            for (j in 0 until n) {
                val c = grid[i][j]
                if (c == '/') {
                    expandedGrid[i * 3][j * 3 + 2] = true
                    expandedGrid[i * 3 + 1][j * 3 + 1] = true
                    expandedGrid[i * 3 + 2][j * 3] = true
                } else if (c == '\\') {
                    expandedGrid[i * 3][j * 3] = true
                    expandedGrid[i * 3 + 1][j * 3 + 1] = true
                    expandedGrid[i * 3 + 2][j * 3 + 2] = true
                }
            }
        }

        // Flood fill to count regions
        var regionsCount = 0
        for (i in 0 until n * 3) {
            for (j in 0 until n * 3) {
                if (!expandedGrid[i][j]) {
                    regionsCount++
                    dfs(expandedGrid, i, j)
                }
            }
        }
        return regionsCount
    }

    // Depth-First Search for filling the region
    fun dfs(grid: Array<BooleanArray>, x: Int, y: Int) {
        val n = grid.size
        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y]) return
        grid[x][y] = true
        dfs(grid, x - 1, y)
        dfs(grid, x + 1, y)
        dfs(grid, x, y - 1)
        dfs(grid, x, y + 1)
    }
}
