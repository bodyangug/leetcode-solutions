package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/special-array-i
class SpecialArrayI {
    fun isArraySpecial(nums: IntArray): Boolean {
        return (0 until nums.size - 1).none { nums[it] % 2 == nums[it + 1] % 2 }
    }
}
