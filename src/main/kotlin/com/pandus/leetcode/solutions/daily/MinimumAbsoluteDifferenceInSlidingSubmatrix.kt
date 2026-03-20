package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix
class MinimumAbsoluteDifferenceInSlidingSubmatrix {
    fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val result = Array(m - k + 1) { IntArray(n - k + 1) }
        val buf = IntArray(k * k)
        for (i in 0..m - k) {
            for (j in 0..n - k) {
                var idx = 0
                for (x in i until i + k) {
                    for (y in j until j + k) {
                        buf[idx++] = grid[x][y]
                    }
                }
                buf.sort()
                var minDiff = Int.MAX_VALUE
                for (t in 1 until buf.size) {
                    if (buf[t] == buf[t - 1]) continue
                    minDiff = minOf(minDiff, buf[t] - buf[t - 1])
                    if (minDiff == 1) break
                }
                if (minDiff != Int.MAX_VALUE) result[i][j] = minDiff
            }
        }
        return result
    }
}
