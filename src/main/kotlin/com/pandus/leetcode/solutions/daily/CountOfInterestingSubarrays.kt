package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-of-interesting-subarrays/description
class CountOfInterestingSubarrays {
    fun countInterestingSubarrays(
        nums: List<Int>,
        modulo: Int,
        k: Int
    ): Long {
        val countMap = HashMap<Int, Int>()
        countMap[0] = 1
        var prefix = 0
        var result = 0L

        for (num in nums) {
            if (num % modulo == k) {
                prefix++
            }
            val key = (prefix - k + modulo) % modulo
            result += countMap.getOrDefault(key, 0)
            val modPrefix = prefix % modulo
            countMap[modPrefix] = countMap.getOrDefault(modPrefix, 0) + 1
        }
        return result
    }
}
