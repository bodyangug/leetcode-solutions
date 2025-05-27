package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/divisible-and-non-divisible-sums-difference
class DivisibleAndNonDivisibleSumsDifference {
    fun differenceOfSums(n: Int, m: Int): Int {
        val totalSum = n * (n + 1) / 2
        val k = n / m
        val divisibleSum = m * k * (k + 1) / 2
        return totalSum - 2 * divisibleSum
    }
}
