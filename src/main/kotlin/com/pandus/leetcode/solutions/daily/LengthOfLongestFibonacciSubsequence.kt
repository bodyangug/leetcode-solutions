package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence
class LengthOfLongestFibonacciSubsequence {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        val index = arr.withIndex().associate { it.value to it.index }
        val dp = mutableMapOf<Pair<Int, Int>, Int>()
        var res = 0
        for (j in arr.indices) {
            for (i in 0 until j) {
                val k = index[arr[j] - arr[i]]
                if (k != null && k < i) {
                    val length = dp.getOrDefault(k to i, 2) + 1
                    dp[i to j] = length
                    res = max(res, length)
                }
            }
        }
        return if (res > 2) res else 0
    }
}
