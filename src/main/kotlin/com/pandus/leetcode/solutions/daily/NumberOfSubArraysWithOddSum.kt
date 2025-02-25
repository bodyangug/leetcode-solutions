package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum
class NumberOfSubArraysWithOddSum {
    fun numOfSubarrays(arr: IntArray): Int {
        val MOD = 1_000_000_007
        var prefixSum = 0
        var evenCount = 1 // To count empty prefix sum (0)
        var oddCount = 0
        var result = 0

        for (num in arr) {
            prefixSum += num
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD
                evenCount++
            } else {
                result = (result + evenCount) % MOD
                oddCount++
            }
        }
        return result
    }
}
