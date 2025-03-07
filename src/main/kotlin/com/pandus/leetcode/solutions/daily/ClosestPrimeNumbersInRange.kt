package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/closest-prime-numbers-in-range
class ClosestPrimeNumbersInRange {
    fun closestPrimes(left: Int, right: Int): IntArray {
        val isPrime = sieve(right)

        var prevPrime = -1
        var minDifference = Int.MAX_VALUE
        val closestPair = intArrayOf(-1, -1)

        for (num in left..right) {
            if (isPrime[num]) {
                if (prevPrime != -1) {
                    val diff = num - prevPrime
                    if (diff < minDifference) {
                        minDifference = diff
                        closestPair[0] = prevPrime
                        closestPair[1] = num
                    }
                }
                prevPrime = num
            }
        }

        return closestPair
    }

    private fun sieve(upperLimit: Int): BooleanArray {
        val isPrime = BooleanArray(upperLimit + 1) { true }
        isPrime[0] = false
        isPrime[1] = false

        for (i in 2..sqrt(upperLimit.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..upperLimit step i) {
                    isPrime[j] = false
                }
            }
        }

        return isPrime
    }
}
