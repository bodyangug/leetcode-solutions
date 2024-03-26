package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/first-missing-positive
class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        for (i in nums.indices) {
            while (nums[i] > 0 && nums[i] <= nums.size && nums[nums[i] - 1] != nums[i]) {
                val temp = nums[i]
                nums[i] = nums[temp - 1]
                nums[temp - 1] = temp
            }
        }
        for (i in nums.indices) {
            if (nums[i] != i + 1) {
                return i + 1
            }
        }
        return nums.size + 1
    }
}

