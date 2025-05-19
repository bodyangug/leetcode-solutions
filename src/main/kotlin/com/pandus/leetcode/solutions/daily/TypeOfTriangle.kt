package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/type-of-triangle
class TypeOfTriangle {
    fun triangleType(nums: IntArray): String {
        nums.sort()
        return when {
            nums[0] + nums[1] <= nums[2] -> "none"
            nums[0] == nums[2] -> "equilateral"
            nums[0] == nums[1] || nums[1] == nums[2] -> "isosceles"
            else -> "scalene"
        }
    }
}
