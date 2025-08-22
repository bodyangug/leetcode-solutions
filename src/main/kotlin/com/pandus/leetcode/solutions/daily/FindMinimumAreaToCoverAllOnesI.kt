package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i
class FindMinimumAreaToCoverAllOnesI {
    fun minimumArea(grid: Array<IntArray>): Int {
        var minRow = Int.MAX_VALUE
        var maxRow = Int.MIN_VALUE
        var minCol = Int.MAX_VALUE
        var maxCol = Int.MIN_VALUE
        var found = false

        for (i in grid.indices) {
            val row = grid[i]
            // quick skip if row has no 1s
            val first = row.indexOf(1)
            if (first == -1) continue

            val last = row.lastIndexOf(1)
            found = true

            if (i < minRow) minRow = i
            if (i > maxRow) maxRow = i
            if (first < minCol) minCol = first
            if (last > maxCol) maxCol = last
        }

        if (!found) return 0
        return (maxRow - minRow + 1) * (maxCol - minCol + 1)
    }
}
