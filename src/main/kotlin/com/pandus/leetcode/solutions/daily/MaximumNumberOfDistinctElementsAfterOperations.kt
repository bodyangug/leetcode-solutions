package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations
class MaximumNumberOfDistinctElementsAfterOperations {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) return 0
        if (k == 0) {
            nums.sort()
            var distinct = 1
            for (i in 1 until nums.size) if (nums[i] != nums[i - 1]) distinct++
            return distinct
        }

        nums.sort()
        var count = 0
        var prev = Long.MIN_VALUE
        val minInt = Int.MIN_VALUE.toLong()
        val maxInt = Int.MAX_VALUE.toLong()

        for (num in nums) {
            val lowerRaw = num.toLong() - k.toLong()
            val upperRaw = num.toLong() + k.toLong()
            val lower = max(lowerRaw, minInt)
            val upper = min(upperRaw, maxInt)

            val candidate = max(prev + 1, lower)
            if (candidate <= upper) {
                count++
                prev = candidate
                if (prev == maxInt) break
            }
        }
        return count
    }
}
