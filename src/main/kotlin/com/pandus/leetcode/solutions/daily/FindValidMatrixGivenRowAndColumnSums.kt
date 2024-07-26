package com.pandus.leetcode.solutions.daily

import kotlin.math.min

//Reference:
class FindValidMatrixGivenRowAndColumnSums {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val m = rowSum.size
        val n = colSum.size

        val sol = Array(m) { IntArray(n) }

        var i = 0
        var j = 0

        for (v in rowSum) {
            while (v > 0) {
                val q = min(v, colSum[j])
                sol[i][j] = q
                rowSum[i] -= q
                colSum[j] -= q
                if (colSum[j] == 0) j++
            }
            i++
        }
        return sol
    }
}