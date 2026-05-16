package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
class FindMinimumInRotatedSortedArrayII {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] > nums[right] -> left = mid + 1
                nums[mid] < nums[right] -> right = mid
                else -> right--
            }
        }
        return nums[left]
    }
}
