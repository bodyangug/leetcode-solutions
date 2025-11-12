package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1
class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var totalGCD = 0
        for (num in nums) {
            totalGCD = gcd(totalGCD, num)
        }
        if (totalGCD != 1) return -1

        var minOps = Int.MAX_VALUE
        for (i in nums.indices) {
            var currentGCD = 0
            for (j in i until n) {
                currentGCD = gcd(currentGCD, nums[j])
                if (currentGCD == 1) {
                    minOps = minOf(minOps, j - i)
                    break
                }
            }
        }

        val countOfOnes = nums.count { it == 1 }
        return if (countOfOnes > 0) n - countOfOnes else n - 1 + minOps
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
