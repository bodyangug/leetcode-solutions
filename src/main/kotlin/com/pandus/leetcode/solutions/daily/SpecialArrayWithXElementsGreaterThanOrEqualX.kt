package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference:https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
class SpecialArrayWithXElementsGreaterThanOrEqualX {
    fun specialArray(nums: IntArray): Int {
        val n = nums.size
        val freq = IntArray(n + 1)

        for (i in 0 until n) {
            freq[min(n, nums[i])]++
        }

        var numGreaterThanOrEqual = 0
        for (i in n downTo 1) {
            numGreaterThanOrEqual += freq[i]
            if (i == numGreaterThanOrEqual) {
                return i
            }
        }

        return -1
    }
}
