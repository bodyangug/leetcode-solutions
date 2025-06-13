package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs
class MinimizeMaximumDifferenceOfPairs {
    private fun countValidPairs(nums: IntArray, threshold: Int): Int {
        var count = 0
        var i = 0
        while (i < nums.size - 1) {
            if (nums[i + 1] - nums[i] <= threshold) {
                count++
                i += 2  // Skip the pair
            } else {
                i++
            }
        }
        return count
    }

    fun minimizeMax(nums: IntArray, p: Int): Int {
        nums.sort()
        var left = 0
        var right = nums.last() - nums.first()

        while (left < right) {
            val mid = (left + right) / 2
            if (countValidPairs(nums, mid) >= p) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}