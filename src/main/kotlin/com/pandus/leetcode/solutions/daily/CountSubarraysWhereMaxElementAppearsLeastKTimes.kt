package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
class CountSubarraysWhereMaxElementAppearsLeastKTimes {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maxElement = nums.maxOrNull()
        var ans: Long = 0
        var start = 0
        var maxElementsInWindow = 0
        for (end in nums.indices) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++
            }
            while (k == maxElementsInWindow) {
                if (nums[start] == maxElement) {
                    maxElementsInWindow--
                }
                start++
            }
            ans += start.toLong()
        }
        return ans
    }
}
