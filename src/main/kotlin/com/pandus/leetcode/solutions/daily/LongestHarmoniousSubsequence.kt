package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-harmonious-subsequence
class LongestHarmoniousSubsequence {
    fun findLHS(nums: IntArray): Int {
        val freq = mutableMapOf<Int, Int>()
        for (num in nums) {
            freq[num] = freq.getOrDefault(num, 0) + 1
        }

        var maxLen = 0
        for ((key, value) in freq) {
            if (freq.containsKey(key + 1)) {
                maxLen = maxOf(maxLen, value + freq[key + 1]!!)
            }
        }

        return maxLen
    }
}
