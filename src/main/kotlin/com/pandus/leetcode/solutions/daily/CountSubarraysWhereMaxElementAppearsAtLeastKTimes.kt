package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maxElement = nums.max()
        var ans: Long = 0
        var start: Long = 0
        var maxElementsInWindow = 0

        for (end in nums.indices) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++
            }
            while (maxElementsInWindow == k) {
                if (nums[start.toInt()] == maxElement) {
                    maxElementsInWindow--
                }
                start++
            }
            ans += start
        }
        return ans
    }
}
