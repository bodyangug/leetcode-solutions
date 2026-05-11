package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/separate-the-digits-in-an-array
class SeparateDigitsInArray {
    fun separateDigits(nums: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (num in nums) {
            val digits = num.toString().map { it - '0' }
            result.addAll(digits)
        }
        return result.toIntArray()
    }
}
