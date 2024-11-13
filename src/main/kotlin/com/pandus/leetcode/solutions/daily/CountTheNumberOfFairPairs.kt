package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-fair-pairs
class CountTheNumberOfFairPairs {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        val sortedNums = nums.sorted()
        var result = 0L
        var left = sortedNums.lastIndex // last index violates lower
        var right = sortedNums.lastIndex // last index satisfies upper

        for ((i, num) in sortedNums.withIndex()) {
            while (0 <= left && lower <= num + sortedNums[left]) {
                left -= 1
            }
            while (0 <= right && upper < num + sortedNums[right]) {
                right -= 1
            }
            val smallerPairs = when {
                i <= left -> 0
                i <= right -> (i - left) - 1 // one for i itself
                else -> right - left
            }
            result += smallerPairs
        }
        return result
    }
}
