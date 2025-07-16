package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/editorial/?envType=daily-question&envId=2025-07-16
class FindMaximumLengthOfValidSubsequenceI {
    fun maximumLength(nums: IntArray): Int {
        val patterns = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )

        return patterns.maxOf { pattern ->
            var count = 0
            for (num in nums) {
                val expected = pattern[count and 1]
                if (num and 1 == expected) count++
            }
            count
        }
    }
}
