package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/largest-perimeter-triangle
class LargestPerimeterTriangle {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sortDescending()
        for (i in 0 until nums.size - 2) {
            val a = nums[i]
            val b = nums[i + 1]
            val c = nums[i + 2]
            if (a < b + c) {
                return a + b + c
            }
        }
        return 0
    }
}
