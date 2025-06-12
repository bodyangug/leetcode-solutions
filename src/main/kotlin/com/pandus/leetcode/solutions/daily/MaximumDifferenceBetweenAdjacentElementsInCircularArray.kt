package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array
class MaximumDifferenceBetweenAdjacentElementsInCircularArray {
    fun maxAdjacentDistance(nums: IntArray): Int {
        val n = nums.size
        var res = abs((nums[0] - nums[n - 1]))
        for (i in 0..<n - 1) {
            res = max(res, abs((nums[i] - nums[i + 1])))
        }
        return res
    }
}
