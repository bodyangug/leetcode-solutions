package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.min

// Reference: https://leetcode.com/problems/sort-matrix-by-diagonals
class SortMatrixByDiagonals {
    fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        if (m == 0) return grid
        val n = grid[0].size

        val buf = IntArray(min(m, n))

        for (startRow in 0 until m) {
            var len = 0
            var i = startRow
            var j = 0
            while (i < m && j < n) {
                buf[len++] = grid[i][j]
                i++
                j++
            }
            Arrays.sort(buf, 0, len)
            i = startRow
            j = 0
            var k = len - 1
            while (i < m && j < n) {
                grid[i][j] = buf[k--]
                i++
                j++
            }
        }

        for (startCol in 1 until n) {
            var len = 0
            var i = 0
            var j = startCol
            while (i < m && j < n) {
                buf[len++] = grid[i][j]
                i++
                j++
            }
            Arrays.sort(buf, 0, len)
            i = 0
            j = startCol
            var k = 0
            while (i < m && j < n) {
                grid[i][j] = buf[k++]
                i++
                j++
            }
        }

        return grid
    }
}
