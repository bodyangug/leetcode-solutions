package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/triangle
class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = Array(triangle.size) { i -> IntArray(triangle[i].size) }
        for (i in triangle.indices) {
            for (j in triangle[i].indices) {
                dp[i][j] = when {
                    i == 0 && j == 0 -> triangle[i][j]
                    j == 0 -> dp[i - 1][j] + triangle[i][j]
                    j == triangle[i].lastIndex -> dp[i - 1][j - 1] + triangle[i][j]
                    else -> minOf(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
                }
            }
        }
        return dp.last().min()
    }
}
