package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-subarrays-with-score-less-than-k
class CountSubarraysWithScoreLessThanK {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        var res = 0L
        var total = 0L
        var i = 0

        for (j in nums.indices) {
            total += nums[j]
            while (i <= j && total * (j - i + 1) >= k) {
                total -= nums[i]
                i++
            }
            res += (j - i + 1)
        }

        return res
    }
}
