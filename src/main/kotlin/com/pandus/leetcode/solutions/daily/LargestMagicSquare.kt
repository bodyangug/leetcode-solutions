package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/largest-magic-square
class LargestMagicSquare {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        // Precompute row and column sums
        val rowSums = Array(m) { IntArray(n + 1) }
        val colSums = Array(n) { IntArray(m + 1) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                rowSums[i][j + 1] = rowSums[i][j] + grid[i][j]
                colSums[j][i + 1] = colSums[j][i] + grid[i][j]
            }
        }

        fun isMagicSquare(x: Int, y: Int, size: Int): Boolean {
            val targetSum = rowSums[x][y + size] - rowSums[x][y]

            // Check rows
            for (i in x until x + size) {
                if (rowSums[i][y + size] - rowSums[i][y] != targetSum) return false
            }

            // Check columns
            for (j in y until y + size) {
                if (colSums[j][x + size] - colSums[j][x] != targetSum) return false
            }

            // Check main diagonal
            var diagSum1 = 0
            for (i in 0 until size) {
                diagSum1 += grid[x + i][y + i]
            }
            if (diagSum1 != targetSum) return false

            // Check secondary diagonal
            var diagSum2 = 0
            for (i in 0 until size) {
                diagSum2 += grid[x + i][y + size - 1 - i]
            }
            if (diagSum2 != targetSum) return false

            return true
        }

        for (size in minOf(m, n) downTo 1) {
            for (i in 0..m - size) {
                for (j in 0..n - size) {
                    if (isMagicSquare(i, j, size)) {
                        return size
                    }
                }
            }
        }

        return 1
    }
}
