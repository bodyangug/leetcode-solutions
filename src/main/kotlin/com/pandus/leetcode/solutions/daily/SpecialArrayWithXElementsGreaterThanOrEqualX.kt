package com.pandus.leetcode.solutions.daily

import kotlin.math.min

//Reference:https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
class SpecialArrayWithXElementsGreaterThanOrEqualX {
    fun specialArray(nums: IntArray): Int {
        val N = nums.size
        val freq = IntArray(N + 1)

        for (i in 0 until N) {
            freq[min(N, nums[i])]++
        }

        var numGreaterThanOrEqual = 0
        for (i in N downTo 1) {
            numGreaterThanOrEqual += freq[i]
            if (i == numGreaterThanOrEqual) {
                return i
            }
        }

        return -1
    }
}