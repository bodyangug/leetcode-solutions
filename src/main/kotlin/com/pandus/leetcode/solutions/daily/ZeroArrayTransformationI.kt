package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/zero-array-transformation-i
class ZeroArrayTransformationI {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val delta = IntArray(nums.size + 1)

        for ((l, r) in queries) {
            delta[l]++
            if (r + 1 < delta.size) delta[r + 1]--
        }

        var operations = 0
        for (i in nums.indices) {
            operations += delta[i]
            if (operations < nums[i]) return false
        }

        return true
    }
}
