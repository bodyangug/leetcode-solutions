package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.max

//Reference: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
class LargestPositiveIntegerThatExistsWithItsNegative {
    fun findMaxK(nums: IntArray): Int {
        var ans = -1
        for (i in nums) {
            for (j in nums) {
                if (i == -j) {
                    ans = max(ans, abs(i))
                }
            }
        }
        return ans
    }
}