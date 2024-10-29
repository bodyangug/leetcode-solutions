package com.pandus.leetcode.solutions.daily

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-number-of-moves-in-a-grid
class MaximumNumberOfMovesInGrid {
    private val dirs = intArrayOf(-1, 0, 1)

    fun maxMoves(grid: Array<IntArray>): Int {
        val M = grid.size
        val N = grid[0].size

        val q: Queue<IntArray> = LinkedList()
        val vis = Array(M) { BooleanArray(N) }

        // Enqueue the cells in the first column.
        for (i in 0 until M) {
            vis[i][0] = true
            q.offer(intArrayOf(i, 0, 0))
        }

        var maxMoves = 0
        while (!q.isEmpty()) {
            var sz = q.size

            while (sz-- > 0) {
                val v = q.poll()

                val row = v[0]
                val col = v[1]
                val count = v[2]

                maxMoves = max(maxMoves.toDouble(), count.toDouble()).toInt()

                for (dir in dirs) {
                    val newRow = row + dir
                    val newCol = col + 1

                    if (newRow >= 0 && newCol >= 0 && newRow < M && newCol < N &&
                        !vis[newRow][newCol] && grid[row][col] < grid[newRow][newCol]
                    ) {
                        vis[newRow][newCol] = true
                        q.offer(intArrayOf(newRow, newCol, count + 1))
                    }
                }
            }
        }
        return maxMoves
    }
}
