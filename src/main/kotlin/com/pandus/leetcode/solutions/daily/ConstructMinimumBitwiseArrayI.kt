package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/construct-the-minimum-bitwise-array-i
class ConstructMinimumBitwiseArrayI {
    fun minBitwiseArray(nums: MutableList<Int>): IntArray {
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            val original: Int = nums[i]
            var candidate = -1
            for (j in 1..<original) {
                if ((j or (j + 1)) == original) {
                    candidate = j
                    break
                }
            }
            result[i] = candidate
        }
        return result
    }
}
