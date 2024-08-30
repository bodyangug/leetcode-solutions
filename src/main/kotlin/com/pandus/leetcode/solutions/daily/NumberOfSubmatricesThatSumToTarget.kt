package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-submatrices-that-sum-to-target
class NumberOfSubmatricesThatSumToTarget {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val rows = matrix.size
        val cols = matrix[0].size

        val prefixSum = Array(rows + 1) { IntArray(cols + 1) }
        for (i in 1 until rows + 1) {
            for (j in 1 until cols + 1) {
                prefixSum[i][j] =
                    prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1]
            }
        }

        var count = 0
        val sumMap: MutableMap<Int, Int> = HashMap()

        for (colStart in 1 until cols + 1) {
            for (colEnd in colStart until cols + 1) {
                sumMap.clear()
                sumMap[0] = 1
                for (row in 1 until rows + 1) {
                    val currSum = prefixSum[row][colEnd] - prefixSum[row][colStart - 1]
                    count += sumMap.getOrDefault(currSum - target, 0)
                    sumMap[currSum] = sumMap.getOrDefault(currSum, 0) + 1
                }
            }
        }

        return count
    }
}
