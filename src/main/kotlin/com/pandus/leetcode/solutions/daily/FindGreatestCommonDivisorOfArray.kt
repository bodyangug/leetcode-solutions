package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-greatest-common-divisor-of-array
class FindGreatestCommonDivisorOfArray {
    fun findGCD(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (num in nums) {
            if (num < min) min = num
            if (num > max) max = num
        }
        return gcd(min, max)
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}
