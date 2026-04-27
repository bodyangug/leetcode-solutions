package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid
class CheckIfThereIsValidPathInGrid {
    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        // directions: 0=left, 1=right, 2=up, 3=down
        val moves = mapOf(
            1 to listOf(0, 1),
            2 to listOf(2, 3),
            3 to listOf(0, 3),
            4 to listOf(1, 3),
            5 to listOf(0, 2),
            6 to listOf(1, 2)
        )
        val dx = intArrayOf(0, 0, -1, 1)
        val dy = intArrayOf(-1, 1, 0, 0)
        val opposite = intArrayOf(1, 0, 3, 2)

        val visited = Array(m) { BooleanArray(n) }
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        queue.add(0 to 0)
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()
            if (x == m - 1 && y == n - 1) return true
            for (dir in moves[grid[x][y]]!!) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]
                if (nx in 0 until m && ny in 0 until n && !visited[nx][ny] &&
                    opposite[dir] in moves[grid[nx][ny]]!!
                ) {
                    visited[nx][ny] = true
                    queue.add(nx to ny)
                }
            }
        }
        return false
    }
}
