package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-xor-for-each-query
class MaximumXORForEachQuery {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val result = IntArray(nums.size)
        var max = nums.fold(0) { acc, num -> acc xor num }
        for (i in nums.lastIndex downTo 0) {
            val k = (1 shl maximumBit) - 1
            result[nums.lastIndex - i] = max xor k
            max = max xor nums[i]
        }

        return result
    }
}
