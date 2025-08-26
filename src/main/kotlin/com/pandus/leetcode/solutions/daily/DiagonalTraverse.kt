package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/diagonal-traverse
class DiagonalTraverse {
    fun findDiagonalOrder(matrix: Array<IntArray>?): IntArray {
        // Handle null/empty safely
        if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) return IntArray(0)

        val n = matrix.size
        val m = matrix[0].size
        val out = IntArray(n * m)
        var k = 0

        // s = i + j (diagonal index)
        for (s in 0 until (n + m - 1)) {
            if (s % 2 == 0) {
                // Traverse "up-right": i decreases, j increases
                var i = minOf(s, n - 1)
                var j = s - i
                while (i >= 0 && j < m) {
                    out[k++] = matrix[i][j]
                    i--
                    j++
                }
            } else {
                // Traverse "down-left": j decreases, i increases
                var j = minOf(s, m - 1)
                var i = s - j
                while (j >= 0 && i < n) {
                    out[k++] = matrix[i][j]
                    i++
                    j--
                }
            }
        }
        return out
    }
}
