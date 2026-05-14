package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-array-is-good
class CheckIfArrayIsGood {
    fun isGood(nums: IntArray): Boolean {
        val n = nums.size - 1
        val count = IntArray(n + 1)
        for (num in nums) {
            if (num < 1 || num > n) return false
            count[num]++
        }
        for (i in 1 until n) {
            if (count[i] != 1) return false
        }
        return count[n] == 2
    }
}
