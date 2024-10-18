package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets
class CountNumberOfMaximumBitwiseORSubsets {
    fun countMaxOrSubsets(nums: IntArray): Int {
        var maxOrValue = 0
        for (num in nums) {
            maxOrValue = maxOrValue or num
        }
        return countSubsets(nums, 0, 0, maxOrValue)
    }

    private fun countSubsets(
        nums: IntArray,
        index: Int,
        currentOr: Int,
        targetOr: Int
    ): Int {
        if (index == nums.size) {
            return if ((currentOr == targetOr)) 1 else 0
        }
        val countWithout = countSubsets(
            nums,
            index + 1,
            currentOr,
            targetOr
        )

        val countWith = countSubsets(
            nums,
            index + 1,
            currentOr or nums[index],
            targetOr
        )
        // Return the sum of both cases
        return countWithout + countWith
    }
}