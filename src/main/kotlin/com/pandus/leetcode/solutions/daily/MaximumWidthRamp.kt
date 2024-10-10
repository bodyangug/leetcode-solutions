package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximum-width-ramp
class MaximumWidthRamp {
    fun maxWidthRamp(nums: IntArray): Int {
        val inds = nums.indices.sortedBy { nums[it] }
        var min = nums.size;
        var max = -1
        return inds.maxOf { i ->
            max = if (i < min) i else max(max, i)
            min = min(min, i)
            max - min
        }
    }
}
