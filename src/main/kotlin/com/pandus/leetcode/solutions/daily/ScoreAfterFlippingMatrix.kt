package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/score-after-flipping-matrix
class ScoreAfterFlippingMatrix {
    fun matrixScore(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        // Set first column
        for (i in 0 until m) {
            if (grid[i][0] == 0) {
                // Flip row
                for (j in 0 until n) {
                    grid[i][j] = 1 - grid[i][j]
                }
            }
        }

        // Optimize columns except first column
        for (j in 1 until n) {
            var countZero = 0
            // Count zeros
            for (i in 0 until m) {
                if (grid[i][j] == 0) {
                    countZero++
                }
            }
            // Flip the column if there are more zeros for better score
            if (countZero > m - countZero) {
                for (i in 0 until m) {
                    grid[i][j] = 1 - grid[i][j]
                }
            }
        }

        // Calculate the final score considering bit positions
        var score = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                // Left shift bit by place value of column to find column contribution
                val columnScore = grid[i][j] shl (n - j - 1)
                // Add contribution to score
                score += columnScore
            }
        }

        // return final result
        return score
    }
}
