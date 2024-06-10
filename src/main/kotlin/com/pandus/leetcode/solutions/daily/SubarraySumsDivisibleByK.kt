package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/subarray-sums-divisible-by-k
class SubarraySumsDivisibleByK {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var prefixMod = 0
        var result = 0

        val modGroups = IntArray(k)
        modGroups[0] = 1

        for (num in nums) {
            prefixMod = (prefixMod + num % k + k) % k
            result += modGroups[prefixMod]
            modGroups[prefixMod]++
        }

        return result
    }
}