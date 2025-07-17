package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii
class FindMaximumLengthOfValidSubsequenceII {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val dp = Array(k) { IntArray(k) } // No nulls
        var res = 0
        for (num in nums) {
            val mod = num % k
            for (prev in 0 until k) {
                val newLen = dp[mod][prev] + 1
                dp[prev][mod] = max(dp[prev][mod], newLen)
                res = max(res, dp[prev][mod])
            }
        }
        return res
    }
}
