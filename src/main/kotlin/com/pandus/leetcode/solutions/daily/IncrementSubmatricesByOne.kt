package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/increment-submatrices-by-one
class IncrementSubmatricesByOne {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray?> {
        val diff = Array<IntArray?>(n + 1) { IntArray(n + 1) }
        for (q in queries) {
            val row1 = q[0]
            val col1 = q[1]
            val row2 = q[2]
            val col2 = q[3]
            diff[row1]!![col1] += 1
            diff[row2 + 1]!![col1] -= 1
            diff[row1]!![col2 + 1] -= 1
            diff[row2 + 1]!![col2 + 1] += 1
        }

        val mat = Array<IntArray?>(n) { IntArray(n) }
        for (i in 0..<n) {
            for (j in 0..<n) {
                val x1 = if (i == 0) 0 else mat[i - 1]!![j]
                val x2 = if (j == 0) 0 else mat[i]!![j - 1]
                val x3 = if (i == 0 || j == 0) 0 else mat[i - 1]!![j - 1]
                mat[i]!![j] = diff[i]!![j] + x1 + x2 - x3
            }
        }
        return mat
    }
}
