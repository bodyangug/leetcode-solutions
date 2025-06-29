package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
class NumberOfSubsequencesThatSatisfyGivenSumCondition {
    fun numSubseq(nums: IntArray, target: Int): Int {
        nums.sort()
        val mod = 1_000_000_007
        val n = nums.size
        val pow = IntArray(n) { 1 }
        for (i in 1 until n) {
            pow[i] = (pow[i - 1] * 2) % mod
        }

        var res = 0
        var left = 0
        var right = n - 1

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + pow[right - left]) % mod
                left++
            } else {
                right--
            }
        }

        return res
    }
}
