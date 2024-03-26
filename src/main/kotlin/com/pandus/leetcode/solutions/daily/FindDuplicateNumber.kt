package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/find-the-duplicate-number
class FindDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        nums.sort()
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) return nums[i]
        }
        return -1
    }
}