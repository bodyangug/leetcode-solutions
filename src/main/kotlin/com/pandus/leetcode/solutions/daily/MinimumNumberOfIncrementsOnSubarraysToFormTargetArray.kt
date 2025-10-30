package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array
class MinimumNumberOfIncrementsOnSubarraysToFormTargetArray {
    fun minNumberOperations(target: IntArray): Int {
        val n = target.size
        var ans = target[0]
        for (i in 1..<n) {
            ans += max(target[i] - target[i - 1], 0)
        }
        return ans
    }
}
