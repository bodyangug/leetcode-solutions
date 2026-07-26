package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-product-of-three-numbers
class MaximumProductOfThreeNumbers {
    fun maximumProduct(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        return maxOf(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1])
    }
}
