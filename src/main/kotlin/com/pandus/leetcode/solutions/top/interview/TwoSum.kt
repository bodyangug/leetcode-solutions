package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/two-sum/
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.indices.forEach { i ->
            for (j in i + 1..<nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(-1, -1)
    }
}
