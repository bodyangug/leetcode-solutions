package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/largest-divisible-subset
class LargestDivisibleSubset {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val n = nums.size
        if (n == 0) return emptyList()

        val EDS = Array(n) { mutableListOf<Int>() }
        nums.sort()

        var largestSubsetIndex = 0
        for (i in 0 until n) {
            var maxSubsetIndex = -1
            for (k in 0 until i)
                if (nums[i] % nums[k] == 0 && (maxSubsetIndex == -1 || EDS[maxSubsetIndex].size < EDS[k].size))
                    maxSubsetIndex = k
            if (maxSubsetIndex != -1)
                EDS[i].addAll(EDS[maxSubsetIndex])
            EDS[i].add(nums[i])
            if (EDS[largestSubsetIndex].size < EDS[i].size)
                largestSubsetIndex = i
        }
        return EDS[largestSubsetIndex]
    }
}