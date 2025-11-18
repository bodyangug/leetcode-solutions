package com.pandus.leetcode.solutions.quest

// Reference: https://leetcode.com/problems/max-consecutive-ones
class MaxConsecutiveOnes {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var temp = 0
        var ans = 0
        for (i in nums.indices) {
            if (nums[i] == 1) {
                temp += 1
            } else {
                ans = maxOf(ans, temp)
                temp = 0
            }
        }
        return maxOf(ans, temp)
    }
}
