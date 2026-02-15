package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-balanced-subarray-i
class LongestBalancedSubarrayI {
    fun longestBalanced(nums: IntArray): Int {
        var maxLength = 0

        for (start in nums.indices) {
            val evenSet = HashSet<Int>()
            val oddSet = HashSet<Int>()

            for (end in start until nums.size) {
                if (nums[end] % 2 == 0) {
                    evenSet.add(nums[end])
                } else {
                    oddSet.add(nums[end])
                }

                if (evenSet.size == oddSet.size) {
                    maxLength = maxOf(maxLength, end - start + 1)
                }
            }
        }
        return maxLength
    }
}
