package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/bitwise-xor-of-all-pairings
class BitwiseXOROfAllPairings {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        var xor1 = 0
        var xor2 = 0
        val len1 = nums1.size
        val len2 = nums2.size
        if (len2 % 2 != 0) {
            for (num in nums1) {
                xor1 = xor1 xor num
            }
        }
        if (len1 % 2 != 0) {
            for (num in nums2) {
                xor2 = xor2 xor num
            }
        }
        return xor1 xor xor2
    }
}
