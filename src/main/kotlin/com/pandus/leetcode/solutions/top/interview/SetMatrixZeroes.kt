package com.pandus.leetcode.solutions.top.interview

// Reference: http://leetcode.com/problems/set-matrix-zeroes
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>) {
        val m = matrix.size
        val n = matrix[0].size
        var firstRowZero = false
        var firstColZero = false

        // Check if first row has any zeros
        for (j in 0 until n) {
            if (matrix[0][j] == 0) {
                firstRowZero = true
                break
            }
        }

        // Check if first column has any zeros
        for (i in 0 until m) {
            if (matrix[i][0] == 0) {
                firstColZero = true
                break
            }
        }

        // Use first row and column as markers
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        // Set matrix cells to 0 based on markers
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        // Zero out first row if needed
        if (firstRowZero) {
            for (j in 0 until n) {
                matrix[0][j] = 0
            }
        }

        // Zero out first column if needed
        if (firstColZero) {
            for (i in 0 until m) {
                matrix[i][0] = 0
            }
        }
    }
}