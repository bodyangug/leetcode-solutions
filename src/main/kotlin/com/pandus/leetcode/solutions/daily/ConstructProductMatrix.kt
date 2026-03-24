package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/construct-product-matrix
class ConstructProductMatrix {
    fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val MOD = 12345
        val n = grid.size
        val m = grid[0].size
        val p = Array(n) { IntArray(m) }

        var suffix: Long = 1
        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                p[i][j] = suffix.toInt()
                suffix = (suffix * grid[i][j]) % MOD
            }
        }

        var prefix: Long = 1
        for (i in 0..<n) {
            for (j in 0..<m) {
                p[i][j] = ((p[i][j].toLong() * prefix) % MOD).toInt()
                prefix = (prefix * grid[i][j]) % MOD
            }
        }
        return p
    }
}
