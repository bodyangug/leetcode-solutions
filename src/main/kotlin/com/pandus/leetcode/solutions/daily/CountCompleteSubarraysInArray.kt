package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-complete-subarrays-in-an-array
class CountCompleteSubarraysInArray {
    fun countCompleteSubarrays(nums: IntArray): Int {
        var result = 0
        val totalDistinct = nums.toSet().size
        val freq = mutableMapOf<Int, Int>()
        var right = 0

        for (left in nums.indices) {
            while (right < nums.size && freq.size < totalDistinct) {
                freq[nums[right]] = freq.getOrDefault(nums[right], 0) + 1
                right++
            }

            if (freq.size == totalDistinct) {
                result += nums.size - right + 1
            }

            // remove leftmost element for next iteration
            val leftNum = nums[left]
            freq[leftNum] = freq[leftNum]!! - 1
            if (freq[leftNum] == 0) {
                freq.remove(leftNum)
            }
        }

        return result
    }
}
