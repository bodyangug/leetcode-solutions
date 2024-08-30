package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/binary-subarrays-with-sum
class BinarySubarraysWithSum {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        var totalCount = 0
        var currentSum = 0
        val freq: MutableMap<Int, Int> = HashMap()
        for (num in nums) {
            currentSum += num
            if (currentSum == goal) {
                totalCount++
            }
            if (freq.containsKey(currentSum - goal)) {
                totalCount += freq[currentSum - goal]!!
            }
            freq[currentSum] = freq.getOrDefault(currentSum, 0) + 1
        }
        return totalCount
    }
}
