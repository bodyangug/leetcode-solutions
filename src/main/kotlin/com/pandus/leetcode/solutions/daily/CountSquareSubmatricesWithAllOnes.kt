package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-square-submatrices-with-all-ones
class CountSquareSubmatricesWithAllOnes {
    fun countSquares(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val dp = Array(m) { IntArray(n) }
        var total = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1
                    } else {
                        dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    }
                    total += dp[i][j]
                }
            }
        }
        return total
    }
}
