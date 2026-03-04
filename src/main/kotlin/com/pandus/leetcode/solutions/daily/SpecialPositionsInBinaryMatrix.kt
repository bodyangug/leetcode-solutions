package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/special-positions-in-a-binary-matrix
class SpecialPositionsInBinaryMatrix {
    fun numSpecial(mat: Array<IntArray>): Int {
        var ans = 0
        for (row in mat.indices) {
            for (column in mat[row].indices) {
                if (mat[row][column] == 1) {
                    // Check if the column has only one 1
                    var columnCount = 0
                    for (i in mat.indices) {
                        if (mat[i][column] == 1) {
                            columnCount++
                        }
                    }
                    // Check if the row has only one 1
                    var rowCount = 0
                    for (j in mat[row].indices) {
                        if (mat[row][j] == 1) {
                            rowCount++
                        }
                    }
                    // Special position: exactly 1 in row AND exactly 1 in column
                    if (columnCount == 1 && rowCount == 1) {
                        ans++
                    }
                }
            }
        }
        return ans
    }
}
