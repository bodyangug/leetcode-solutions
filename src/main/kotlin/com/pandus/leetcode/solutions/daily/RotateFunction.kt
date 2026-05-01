package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/rotate-function
class RotateFunction {
    fun maxRotateFunction(nums: IntArray): Int {
        val n = nums.size
        var f = 0
        var sum = 0
        for (i in nums.indices) {
            f += i * nums[i]
            sum += nums[i]
        }
        var maxF = f
        for (k in 1 until n) {
            f += sum - n * nums[n - k]
            maxF = maxOf(maxF, f)
        }
        return maxF
    }
}