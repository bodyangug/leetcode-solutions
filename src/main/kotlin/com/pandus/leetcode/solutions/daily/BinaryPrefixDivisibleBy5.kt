package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/binary-prefix-divisible-by-5
class BinaryPrefixDivisibleBy5 {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        val ans = mutableListOf<Boolean>()
        var prefix = 0
        for (num in nums) {
            prefix = ((prefix shl 1) + num) % 10
            ans.add(prefix % 5 == 0)
        }
        return ans
    }
}
