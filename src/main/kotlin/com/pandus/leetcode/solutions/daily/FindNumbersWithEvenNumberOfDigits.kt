package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-numbers-with-even-number-of-digits
class FindNumbersWithEvenNumberOfDigits {
    fun findNumbers(nums: IntArray): Int {
        return nums.count { it.toString().length % 2 == 0 }
    }
}
