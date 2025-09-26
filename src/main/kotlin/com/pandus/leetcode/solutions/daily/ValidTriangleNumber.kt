package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/valid-triangle-number
class ValidTriangleNumber {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var count = 0
        for (i in 0 until nums.size - 2) {
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left]
                if (sum > nums[right]) {
                    count += right - left
                    left++
                } else {
                    right--
                }
            }
        }
        return count
    }
}
