package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
class FindMinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return nums[left]
    }
}
