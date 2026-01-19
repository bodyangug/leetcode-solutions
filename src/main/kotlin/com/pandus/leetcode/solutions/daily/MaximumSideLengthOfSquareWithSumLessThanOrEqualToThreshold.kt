package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
class MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val m = mat.size
        val n = mat[0].size
        val prefixSum = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                prefixSum[i][j] =
                    mat[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
            }
        }

        var left = 0
        var right = m.coerceAtMost(n)
        var result = 0

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (canFindSquare(prefixSum, mid, threshold)) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }

    private fun canFindSquare(prefixSum: Array<IntArray>, mid: Int, threshold: Int): Boolean {
        val m = prefixSum.size - 1
        val n = prefixSum[0].size - 1

        for (i in mid..m) {
            for (j in mid..n) {
                val total =
                    prefixSum[i][j] - prefixSum[i - mid][j] - prefixSum[i][j - mid] + prefixSum[i - mid][j - mid]
                if (total <= threshold) {
                    return true
                }
            }
        }
        return false
    }
}
