package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations
class SmallestMissingNonNegativeIntegerAfterOperations {
    fun findSmallestInteger(nums: IntArray, value: Int): Int {
        val cnt = IntArray(value)
        for (x in nums) {
            val r = ((x % value) + value) % value
            cnt[r]++
        }

        var m = 0
        while (true) {
            val r = m % value
            if (cnt[r] == 0) return m
            cnt[r]--
            m++
        }
    }
}
