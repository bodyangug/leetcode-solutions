package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximal-rectangle
class MaximalRectangle {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) return 0
        var maxarea = 0
        val dp = Array(matrix.size) { IntArray(matrix[0].size) }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == '1') {
                    // compute the maximum width and update dp with it
                    dp[i][j] = if (j == 0) 1 else dp[i][j - 1] + 1
                    var width = dp[i][j]

                    // compute the maximum area rectangle with a lower right corner at [i, j]
                    for (k in i downTo 0) {
                        width = min(width, dp[k][j])
                        maxarea = max(maxarea, (width * (i - k + 1)))
                    }
                }
            }
        }
        return maxarea
    }
}
