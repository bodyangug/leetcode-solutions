package com.pandus.leetcode.solutions.daily

import java.util.LinkedList

// Reference: https://leetcode.com/problems/number-of-islands
class NumberOfIslands {

    private val directions = arrayOf(
        intArrayOf(0, 1), // up
        intArrayOf(0, -1), // down
        intArrayOf(-1, 0), // left
        intArrayOf(1, 0) //
    )
    private var m: Int = -1
    private var n: Int = -1

    fun numIslands(grid: Array<CharArray>): Int {
        var ans = 0
        m = grid.size
        n = grid[0].size

        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == '1') {
                    ans++
                    bfs(grid, r, c)
                }
            }
        }
        return ans
    }

    private fun bfs(grid: Array<CharArray>, r: Int, c: Int) {
        val queue = LinkedList<IntArray>()
        queue.offer(intArrayOf(r, c))
        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            for (dir in directions) {
                val nr = curr[0] + dir[0]
                val nc = curr[1] + dir[1]
                if ((nr in 0..<m) &&
                    (nc in 0..<n) &&
                    grid[nr][nc] == '1'
                ) {
                    grid[nr][nc] = '0'
                    queue.offer(intArrayOf(nr, nc))
                }
            }
        }
    }
}
