package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid
class GetBiggestThreeRhombusSumsInGrid {
    fun getBiggestThree(grid: Array<IntArray>): IntArray {
        val m = grid.size
        val n = grid[0].size
        val seen = sortedSetOf<Int>()

        for (r in 0 until m) {
            for (c in 0 until n) {
                seen.add(grid[r][c])
                if (seen.size > 3) seen.remove(seen.first())

                val maxSize = minOf(r, m - 1 - r, c, n - 1 - c)
                for (s in 1..maxSize) {
                    var sum = 0
                    for (i in 0 until s) {
                        sum += grid[r - s + i][c + i]       // top to right
                        sum += grid[r + i][c + s - i]       // right to bottom
                        sum += grid[r + s - i][c - i]       // bottom to left
                        sum += grid[r - i][c - s + i]       // left to top
                    }
                    seen.add(sum)
                    if (seen.size > 3) seen.remove(seen.first())
                }
            }
        }

        return seen.reversed().toIntArray()
    }
}
