package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/count-number-of-nice-subarrays
class CountNumberOfNiceSubarrays {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        var currSum = 0
        var subarrays = 0
        val prefixSum: MutableMap<Int, Int> = HashMap()
        prefixSum[currSum] = 1

        for (i in nums.indices) {
            currSum += nums[i] % 2
            // Find subarrays with sum k ending at i
            if (prefixSum.containsKey(currSum - k)) {
                subarrays += prefixSum[currSum - k]!!
            }
            // Increment the current prefix sum in hashmap
            prefixSum[currSum] = prefixSum.getOrDefault(currSum, 0) + 1
        }

        return subarrays
    }
}