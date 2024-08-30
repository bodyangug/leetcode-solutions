package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/subarray-product-less-than-k
class SubarrayProductLessThanK {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0
        var totalCount = 0
        var product = 1

        var left = 0
        var right = 0
        while (right < nums.size) {
            product *= nums[right]
            while (product >= k) {
                product /= nums[left++]
            }
            totalCount += right - left + 1
            right++
        }
        return totalCount
    }
}
