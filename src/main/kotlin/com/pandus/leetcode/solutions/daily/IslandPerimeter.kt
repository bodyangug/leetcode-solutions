package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/island-perimeter
class IslandPerimeter {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        var up: Int
        var down: Int
        var left: Int
        var right: Int
        var result = 0
        val rows: Int = grid.size
        val cols: Int = grid[0].size

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    up = if (r == 0) {
                        0
                    } else {
                        grid[r - 1][c]
                    }
                    left = if (c == 0) {
                        0
                    } else {
                        grid[r][c - 1]
                    }
                    down = if (r == rows - 1) {
                        0
                    } else {
                        grid[r + 1][c]
                    }
                    right = if (c == cols - 1) {
                        0
                    } else {
                        grid[r][c + 1]
                    }
                    result += 4 - (up + left + right + down)
                }
            }
        }

        return result
    }
}
