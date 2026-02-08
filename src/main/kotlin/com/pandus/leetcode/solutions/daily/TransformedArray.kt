package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/transformed-array
class TransformedArray {
    fun constructTransformedArray(nums: IntArray): IntArray {
        val n: Int = nums.size
        val res = IntArray(n)
        for (i in 0..<n) {
            res[i] = nums[(((i + nums[i]) % n) + n) % n]
        }
        return res
    }
}
