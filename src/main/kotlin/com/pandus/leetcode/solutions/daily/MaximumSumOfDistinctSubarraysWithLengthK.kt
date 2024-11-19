package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k
class MaximumSumOfDistinctSubarraysWithLengthK {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var ans: Long = 0
        var currentSum: Long = 0
        var begin = 0
        var end = 0

        val numToIndex = HashMap<Int, Int>()

        while (end < nums.size) {
            val currNum = nums[end]
            val lastOccurrence = numToIndex.getOrDefault(currNum, -1)
            while (begin <= lastOccurrence || end - begin + 1 > k) {
                currentSum -= nums[begin]
                begin++
            }
            numToIndex[currNum] = end
            currentSum += nums[end]
            if (end - begin + 1 == k) {
                ans = max(ans, currentSum)
            }
            end++
        }
        return ans
    }
}
