package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sum-of-gcd-of-formed-pairs
class SumOfGCDOfFormedPairs {
    fun gcdSum(nums: IntArray): Long {
        val n = nums.size
        val prefixGcd = IntArray(n)
        var mxi = nums[0]
        for (i in 0 until n) {
            mxi = maxOf(mxi, nums[i])
            prefixGcd[i] = gcd(nums[i], mxi)
        }
        prefixGcd.sort()
        var sum: Long = 0
        for (i in 0 until n / 2) {
            sum += gcd(prefixGcd[i], prefixGcd[n - 1 - i])
        }
        return sum
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}
