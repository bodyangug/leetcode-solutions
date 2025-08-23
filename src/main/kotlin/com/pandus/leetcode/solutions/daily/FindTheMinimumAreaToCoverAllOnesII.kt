package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: http://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-ii
class FindTheMinimumAreaToCoverAllOnesII {
    private val INF = Int.MAX_VALUE / 3

    private fun minimumSum2(
        grid: Array<IntArray?>,
        u: Int,
        d: Int,
        l: Int,
        r: Int
    ): Int {
        var minRow = Int.MAX_VALUE
        var maxRow = Int.MIN_VALUE
        var minCol = Int.MAX_VALUE
        var maxCol = Int.MIN_VALUE

        for (i in u..d) {
            val row = grid[i] ?: continue
            for (j in l..r) {
                if (row[j] == 1) {
                    if (i < minRow) minRow = i
                    if (i > maxRow) maxRow = i
                    if (j < minCol) minCol = j
                    if (j > maxCol) maxCol = j
                }
            }
        }

        return if (maxRow == Int.MIN_VALUE) INF
        else (maxRow - minRow + 1) * (maxCol - minCol + 1)
    }

    private fun rotate(src: Array<IntArray?>): Array<IntArray?> {
        val n = src.size
        val m = src[0]!!.size
        val dst = Array<IntArray?>(m) { IntArray(n) }

        for (i in 0 until n) {
            val row = src[i]!!
            for (j in 0 until m) {
                dst[m - j - 1]!![i] = row[j]
            }
        }
        return dst
    }

    private fun solve(grid: Array<IntArray?>): Int {
        val n = grid.size
        val m = grid[0]!!.size
        var best = n * m

        for (i in 0 until n - 1) {
            for (j in 0 until m - 1) {
                best = min(
                    best,
                    minimumSum2(grid, 0, i, 0, m - 1) +
                            minimumSum2(grid, i + 1, n - 1, 0, j) +
                            minimumSum2(grid, i + 1, n - 1, j + 1, m - 1)
                )
                best = min(
                    best,
                    minimumSum2(grid, 0, i, 0, j) +
                            minimumSum2(grid, 0, i, j + 1, m - 1) +
                            minimumSum2(grid, i + 1, n - 1, 0, m - 1)
                )
            }
        }

        for (top in 0 until n - 2) {
            for (midEnd in top + 1 until n - 1) {
                best = min(
                    best,
                    minimumSum2(grid, 0, top, 0, m - 1) +
                            minimumSum2(grid, top + 1, midEnd, 0, m - 1) +
                            minimumSum2(grid, midEnd + 1, n - 1, 0, m - 1)
                )
            }
        }
        return best
    }

    fun minimumSum(grid: Array<IntArray?>): Int {
        val rotated = rotate(grid)
        return min(solve(grid), solve(rotated))
    }
}
