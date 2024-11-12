package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/prime-subtraction-operation
class PrimeSubtractionOperation {
    private fun checkPrime(x: Int): Boolean {
        var i = 2
        while (i <= sqrt(x.toDouble())) {
            if (x % i == 0) {
                return false
            }
            i++
        }
        return true
    }

    fun primeSubOperation(nums: IntArray): Boolean {
        for (i in nums.indices) {
            val bound = if (i == 0) {
                nums[0]
            } else {
                nums[i] - nums[i - 1]
            }

            if (bound <= 0) {
                return false
            }

            var largestPrime = 0
            for (j in bound - 1 downTo 2) {
                if (checkPrime(j)) {
                    largestPrime = j
                    break
                }
            }

            nums[i] = nums[i] - largestPrime
        }
        return true
    }
}
