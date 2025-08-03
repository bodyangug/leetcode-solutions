package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps
class MaximumFruitsHarvestedAfterAtMostKSteps {
    fun maxTotalFruits(fruits: Array<IntArray>, startPos: Int, k: Int): Int {
        val n = fruits.size
        val indices = IntArray(n) { fruits[it][0] }
        val sum = IntArray(n + 1)
        for (i in 0 until n) {
            sum[i + 1] = sum[i] + fruits[i][1]
        }

        fun lowerBound(arr: IntArray, key: Int): Int {
            val i = arr.binarySearch(key)
            return if (i >= 0) i else -i - 1
        }

        fun upperBound(arr: IntArray, key: Int): Int {
            val i = arr.binarySearch(key + 1)
            return if (i >= 0) i else -i - 1
        }

        fun collect(left: Int, right: Int): Int {
            val start = lowerBound(indices, left)
            val end = upperBound(indices, right)
            return sum[end] - sum[start]
        }

        var ans = 0
        for (x in 0..k / 2) {
            ans = max(ans, collect(startPos - x, startPos + (k - 2 * x)))
            ans = max(ans, collect(startPos - (k - 2 * x), startPos + x))
        }
        return ans
    }
}
