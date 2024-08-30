package com.pandus.leetcode.solutions.daily

import java.util.LinkedList
import java.util.Queue

//Reference: https://leetcode.com/problems/count-sub-islands
class CountSubIslands {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )

    private fun isCellLand(x: Int, y: Int, grid: Array<IntArray>): Boolean {
        return grid[x][y] == 1
    }

    private fun isSubIsland(
        x: Int,
        y: Int,
        grid1: Array<IntArray>,
        grid2: Array<IntArray>,
        visited: Array<BooleanArray>
    ): Boolean {
        val totalRows = grid2.size
        val totalCols = grid2[0].size
        var isSubIsland = true
        val pendingCells: Queue<IntArray> = LinkedList()

        pendingCells.offer(intArrayOf(x, y))
        visited[x][y] = true

        while (!pendingCells.isEmpty()) {
            val curr = pendingCells.poll()
            val currX = curr[0]
            val currY = curr[1]

            if (!isCellLand(currX, currY, grid1)) {
                isSubIsland = false
            }

            for (direction in directions) {
                val nextX = currX + direction[0]
                val nextY = currY + direction[1]

                if (nextX >= 0
                    && nextY >= 0
                    && nextX < totalRows
                    && nextY < totalCols
                    && !visited[nextX][nextY]
                    && isCellLand(nextX, nextY, grid2)
                ) {
                    pendingCells.offer(intArrayOf(nextX, nextY))
                    visited[nextX][nextY] = true
                }
            }
        }

        return isSubIsland
    }

    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        val totalRows = grid2.size
        val totalCols = grid2[0].size

        val visited = Array(totalRows) { BooleanArray(totalCols) }
        var subIslandCounts = 0

        for (x in 0 until totalRows) {
            for (y in 0 until totalCols) {
                if (!visited[x][y] &&
                    isCellLand(x, y, grid2) &&
                    isSubIsland(x, y, grid1, grid2, visited)
                ) {
                    subIslandCounts += 1
                }
            }
        }
        return subIslandCounts
    }
}