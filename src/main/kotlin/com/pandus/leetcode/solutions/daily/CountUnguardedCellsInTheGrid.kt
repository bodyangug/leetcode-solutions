package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-unguarded-cells-in-the-grid
class CountUnguardedCellsInTheGrid {
    private val UNGUARDED: Int = 0
    private val GUARDED: Int = 1
    private val GUARD: Int = 2
    private val WALL: Int = 3

    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val grid = Array(m) { IntArray(n) }

        // Mark guards' positions
        for (guard in guards) {
            grid[guard[0]][guard[1]] = GUARD
        }

        // Mark walls' positions
        for (wall in walls) {
            grid[wall[0]][wall[1]] = WALL
        }

        // Mark cells as guarded by traversing from each guard
        for (guard in guards) {
            markguarded(guard[0], guard[1], grid)
        }

        // Count unguarded cells
        var count = 0
        for (row in grid) {
            for (cell in row) {
                if (cell == UNGUARDED) count++
            }
        }
        return count
    }

    private fun markguarded(row: Int, col: Int, grid: Array<IntArray>) {
        // Traverse upwards
        for (r in row - 1 downTo 0) {
            if (grid[r][col] == WALL || grid[r][col] == GUARD) break
            grid[r][col] = GUARDED
        }
        // Traverse downwards
        for (r in row + 1 until grid.size) {
            if (grid[r][col] == WALL || grid[r][col] == GUARD) break
            grid[r][col] = GUARDED
        }
        // Traverse leftwards
        for (c in col - 1 downTo 0) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) break
            grid[row][c] = GUARDED
        }
        // Traverse rightwards
        for (c in col + 1 until grid[0].size) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) break
            grid[row][c] = GUARDED
        }
    }
}
