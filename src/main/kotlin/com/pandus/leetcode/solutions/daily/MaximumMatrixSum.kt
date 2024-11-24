package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximum-matrix-sum
class MaximumMatrixSum {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var totalSum: Long = 0
        var minAbsVal = Int.MAX_VALUE
        var negativeCount = 0

        for (row in matrix) {
            for (number in row) {
                totalSum += abs(number)
                if (number < 0) {
                    negativeCount++
                }
                minAbsVal = min(minAbsVal, abs(number))
            }
        }
        if (negativeCount % 2 != 0) {
            totalSum -= (2 * minAbsVal)
        }
        return totalSum
    }
}
