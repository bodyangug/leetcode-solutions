package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-score-triangulation-of-polygon
class MinimumScoreTriangulationOfPolygon {
    fun minScoreTriangulation(values: IntArray): Int {
        val n = values.size
        val dp = Array(n) { IntArray(n) }
        for (len in 3..n) {
            for (i in 0..n - len) {
                val j = i + len - 1
                var best = Int.MAX_VALUE
                for (k in i + 1 until j) {
                    val cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]
                    if (cost < best) best = cost
                }
                dp[i][j] = best
            }
        }
        return dp[0][n - 1]
    }
}
