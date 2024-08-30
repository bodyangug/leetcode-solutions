package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference:https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency
class LengthOfLongestSubarrayWithAtMostKFrequency {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        var ans = 0
        var start = -1
        val frequency = LinkedHashMap<Int, Int>()
        for (idx in nums.indices) {
            frequency[nums[idx]] = frequency.getOrDefault(nums[idx], 0) + 1
            while (frequency[nums[idx]]!! > k) {
                start++
                frequency[nums[start]] = frequency[nums[start]]!! - 1
            }
            ans = max(ans, (idx - start))
        }
        return ans
    }
}
