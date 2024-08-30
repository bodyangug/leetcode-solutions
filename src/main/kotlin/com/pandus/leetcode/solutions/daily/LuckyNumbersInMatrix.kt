package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/lucky-numbers-in-a-matrix
class LuckyNumbersInMatrix {

    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val n = matrix.size
        val m = matrix[0].size
        val rowMins = IntArray(n) { Int.MAX_VALUE }
        val colMaxs = IntArray(m) { Int.MIN_VALUE }

        for (i in 0 until n) {
            for (j in 0 until m) {
                rowMins[i] = minOf(rowMins[i], matrix[i][j])
                colMaxs[j] = maxOf(colMaxs[j], matrix[i][j])
            }
        }

        val res = mutableListOf<Int>()
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] == rowMins[i] && matrix[i][j] == colMaxs[j]) {
                    res.add(matrix[i][j])
                }
            }
        }

        return res
    }
}
