package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/find-if-array-can-be-sorted
class FindIfArrayCanBeSorted {
    fun canSortArray(nums: IntArray): Boolean {
        var curBits = 0
        var prevMax = 0
        var max = 0
        for (num in nums) {
            val bits = num.countOneBits()
            if (bits != curBits) {
                curBits = bits
                prevMax = max
            }
            if (num < prevMax) return false
            max = max(max, num)
        }
        return true
    }
}
