package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment
class LengthOfLongestVShapedDiagonalSegment {
    fun lenOfVDiagonal(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        val visited = Array(n) { BooleanArray(m) }
        val cache = Array(n) { Array(m) { Array(2) { Array(2) { IntArray(2) { -1 } } } } }

        fun backtrack(i: Int, j: Int, di: Int, dj: Int, turn: Boolean, validDigit: Int): Int {
            if (i !in 0..<n || j !in 0..<m || visited[i][j] || grid[i][j] != validDigit) return 0

            val diIndex = (di + 1) shr 1
            val djIndex = (dj + 1) shr 1
            val turnIndex = if (turn) 1 else 0
            if (cache[i][j][diIndex][djIndex][turnIndex] != -1) {
                return cache[i][j][diIndex][djIndex][turnIndex]
            }

            visited[i][j] = true
            val nextValidDigit = (validDigit + 2) and 2
            var result = 1 + backtrack(i + di, j + dj, di, dj, turn, nextValidDigit)
            if (!turn) {
                result = max(result, 1 + backtrack(i + dj, j - di, dj, -di, true, nextValidDigit))
            }
            visited[i][j] = false
            cache[i][j][diIndex][djIndex][turnIndex] = result
            return result
        }

        var ans = 0
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (grid[i][j] == 1) {
                    for ((di, dj) in listOf(1 to 1, 1 to -1, -1 to 1, -1 to -1)) {
                        ans = max(ans, 1 + backtrack(i + di, j + dj, di, dj, false, 2))
                    }
                }
            }
        }

        return ans
    }
}
