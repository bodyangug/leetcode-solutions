package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/rotate-image
class RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        // Transpose
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
        // Reverse each row
        for (i in 0 until n) {
            matrix[i].reverse()
        }
    }
}
