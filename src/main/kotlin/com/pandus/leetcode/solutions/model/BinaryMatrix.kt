package com.pandus.leetcode.solutions.model

class BinaryMatrix(private val matrix: Array<IntArray>) {
    fun get(row: Int, col: Int): Int {
        return matrix[row][col]
    }

    fun dimensions(): List<Int> {
        return listOf(matrix.size, if (matrix.isNotEmpty()) matrix[0].size else 0)
    }
}
