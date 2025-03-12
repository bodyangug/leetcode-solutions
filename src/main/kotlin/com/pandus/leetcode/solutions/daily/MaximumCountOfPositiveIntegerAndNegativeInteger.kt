package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer
class MaximumCountOfPositiveIntegerAndNegativeInteger {

    private fun firstGreaterOrEqual(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = (left + right) ushr 1
            if (nums[mid] >= target) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun firstGreater(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = (left + right) ushr 1
            if (nums[mid] > target) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun maximumCount(nums: IntArray): Int {
        // 1. Index of first non-negative number:
        val idxFirstNonNegative = firstGreaterOrEqual(nums, 0)
        // 2. Index of first positive number:
        val idxFirstPositive = firstGreater(nums, 0)

        // Negative count = all elements before idxFirstNonNegative
        val negatives = idxFirstNonNegative

        // Positive count = all elements from idxFirstPositive to end
        val positives = nums.size - idxFirstPositive
        return maxOf(negatives, positives)
    }
}
