package com.pandus.leetcode.solutions.daily

import java.util.Arrays
import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/partition-array-for-maximum-sum
class PartitionArrayForMaximumSum {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val n = arr.size
        val dp = IntArray(n + 1)
        Arrays.fill(dp, 0)
        for (start in n - 1 downTo 0) {
            var currMax = 0
            val end = min(n.toDouble(), (start + k).toDouble()).toInt()
            for (i in start until end) {
                currMax = max(currMax.toDouble(), arr[i].toDouble()).toInt()
                dp[start] =
                    max(dp[start].toDouble(), (dp[i + 1] + currMax * (i - start + 1)).toDouble()).toInt()
            }
        }
        return dp[0]
    }
}
