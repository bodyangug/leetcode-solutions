package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-good-subarrays
class CountTheNumberOfGoodSubarrays {
    fun countGood(nums: IntArray, k: Int): Long {
        val count = mutableMapOf<Int, Int>()
        var left = 0
        var pairs = 0L
        var result = 0L

        for (right in nums.indices) {
            val freq = count.getOrDefault(nums[right], 0)
            pairs += freq
            count[nums[right]] = freq + 1

            while (pairs >= k) {
                result += nums.size - right
                val leftFreq = count.getOrDefault(nums[left], 0)
                pairs -= (leftFreq - 1)
                count[nums[left]] = leftFreq - 1
                left++
            }
        }
        return result
    }
}
