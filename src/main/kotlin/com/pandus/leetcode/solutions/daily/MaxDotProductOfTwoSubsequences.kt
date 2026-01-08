package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/max-dot-product-of-two-subsequences
class MaxDotProductOfTwoSubsequences {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val m = nums2.size
        val dp = Array(n + 1) { IntArray(m + 1) { Int.MIN_VALUE / 2 } }

        for (i in 1..n) {
            for (j in 1..m) {
                val product = nums1[i - 1] * nums2[j - 1]
                dp[i][j] = maxOf(
                    dp[i - 1][j],
                    dp[i][j - 1],
                    dp[i - 1][j - 1] + product,
                    product
                )
            }
        }

        return dp[n][m]
    }
}
