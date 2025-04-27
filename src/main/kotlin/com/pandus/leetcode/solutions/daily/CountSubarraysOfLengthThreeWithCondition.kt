package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition
class CountSubarraysOfLengthThreeWithCondition {
    fun countSubarrays(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        for (i in 1..<n - 1) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ++ans
            }
        }
        return ans
    }
}
