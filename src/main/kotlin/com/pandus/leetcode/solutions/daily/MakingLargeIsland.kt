package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/making-a-large-island
class MakingLargeIsland {
    fun largestIsland(grid: Array<IntArray>): Int {
        val islandSizes = mutableMapOf<Int, Int>()
        var islandId = 2
        val directions = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 1) {
                    islandSizes[islandId] = markIsland(grid, row, col, islandId)
                    islandId++
                }
            }
        }

        val maxIsland = islandSizes.values.maxOrNull() ?: 0
        if (maxIsland == grid.size * grid[0].size) return maxIsland
        if (islandSizes.isEmpty()) return 1

        var maxSize = maxIsland

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 0) {
                    val neighboringIslands = mutableSetOf<Int>()

                    for ((dx, dy) in directions) {
                        val newRow = row + dx
                        val newCol = col + dy
                        if (newRow in grid.indices && newCol in grid[0].indices && grid[newRow][newCol] > 1) {
                            neighboringIslands.add(grid[newRow][newCol])
                        }
                    }

                    val newSize = 1 + neighboringIslands.sumOf { islandSizes[it] ?: 0 }
                    maxSize = maxOf(maxSize, newSize)
                }
            }
        }

        return maxSize
    }

    private fun markIsland(grid: Array<IntArray>, row: Int, col: Int, islandId: Int): Int {
        if (row !in grid.indices || col !in grid[0].indices || grid[row][col] != 1) return 0

        grid[row][col] = islandId
        val directions = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

        return 1 + directions.sumOf { (dx, dy) -> markIsland(grid, row + dx, col + dy, islandId) }
    }
}
