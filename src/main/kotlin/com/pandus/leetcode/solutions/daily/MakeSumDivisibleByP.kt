package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/make-sum-divisible-by-p
class MakeSumDivisibleByP {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val n = nums.size
        val prefix = LongArray(n + 1) { 0 }
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        val required = prefix[n] % p
        if (required.toInt() == 0) return 0

        for (windowSize in 1 until n) {
            var j = 0
            while (j + windowSize - 1 < n) {
                if ((prefix[j + windowSize] - prefix[j]) % p == required) return windowSize
                j++
            }
        }
        return -1
    }
}
