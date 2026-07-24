package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-unique-xor-triplets-i
class NumberOfUniqueXORTripletsI {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val n = nums.size
        if (n < 3) return n

        var bits = 0
        var value = n
        while (value > 0) {
            bits++
            value = value shr 1
        }

        return 1 shl bits
    }
}
