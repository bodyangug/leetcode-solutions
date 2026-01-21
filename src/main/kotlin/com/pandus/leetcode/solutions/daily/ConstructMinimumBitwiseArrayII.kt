package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii
class ConstructMinimumBitwiseArrayII {
    fun minBitwiseArray(nums: MutableList<Int>): IntArray {
        val n = nums.size
        val result = IntArray(n)
        for (i in 0..<n) {
            val x: Int = nums[i]
            var res = -1
            var d = 1
            while ((x and d) != 0) {
                res = x - d
                d = d shl 1
            }
            result[i] = res
        }
        return result
    }
}
