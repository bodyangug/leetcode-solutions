package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/gcd-of-odd-and-even-sums
class GCDOfOddAndEvenSums {
    fun gcdOfOddEvenSums(n: Int): Int {
        // The sum of the first n positive odd numbers is n^2
        val sumOdd = n * n

        // The sum of the first n positive even numbers is n * (n + 1)
        val sumEven = n * (n + 1)

        // Calculate GCD using Euclidean algorithm
        return gcd(sumOdd, sumEven)
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}
