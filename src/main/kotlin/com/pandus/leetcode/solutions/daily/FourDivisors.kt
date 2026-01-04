package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/four-divisors
class FourDivisors {
    fun sumFourDivisors(nums: IntArray): Int {
        var totalSum = 0
        for (num in nums) {
            val divisors = mutableListOf<Int>()
            for (i in 1..sqrt(num.toDouble()).toInt()) {
                if (num % i == 0) {
                    divisors.add(i)
                    if (i != num / i) {
                        divisors.add(num / i)
                    }
                }
                if (divisors.size > 4) break
            }
            if (divisors.size == 4) {
                totalSum += divisors.sum()
            }
        }
        return totalSum
    }
}
