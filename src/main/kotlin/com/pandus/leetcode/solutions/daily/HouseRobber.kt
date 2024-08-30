package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/house-robber
class HouseRobber {
    fun rob(nums: IntArray): Int {
        val memo = IntArray(nums.size) { -1 }
        return robFrom(0, nums, memo)
    }

    private fun robFrom(currentIndex: Int, nums: IntArray, memo: IntArray): Int {
        if (currentIndex >= nums.size) {
            return 0
        }

        if (memo[currentIndex] > -1) {
            return memo[currentIndex]
        }

        val maxAmount = maxOf(
            robFrom(currentIndex + 1, nums, memo),
            nums[currentIndex] + robFrom(currentIndex + 2, nums, memo)
        )

        memo[currentIndex] = maxAmount
        return maxAmount
    }
}
