package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/last-day-where-you-can-still-cross
class LastDayWhereYouCanStillCross {
    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        var left = 1
        var right = cells.size
        var result = 0

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (canCross(row, col, cells, mid)) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }

    private fun canCross(row: Int, col: Int, cells: Array<IntArray>, idx: Int): Boolean {
        val grid = Array(row) { IntArray(col) { 0 } }
        for (i in 0 until idx) {
            val r = cells[i][0] - 1
            val c = cells[i][1] - 1
            grid[r][c] = 1
        }

        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        val visited = Array(row) { BooleanArray(col) { false } }
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()

        for (c in 0 until col) {
            if (grid[0][c] == 0) {
                queue.add(Pair(0, c))
                visited[0][c] = true
            }
        }

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            if (r == row - 1) {
                return true
            }

            for (dir in directions) {
                val newRow = r + dir[0]
                val newCol = c + dir[1]

                if (newRow in 0 until row && newCol in 0 until col &&
                    grid[newRow][newCol] == 0 && !visited[newRow][newCol]
                ) {
                    queue.add(Pair(newRow, newCol))
                    visited[newRow][newCol] = true
                }
            }
        }

        return false
    }
}
