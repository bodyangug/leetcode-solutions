package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
class CountOddNumbersInIntervalRange {
    fun countOdds(low: Int, high: Int): Int {
        var count = 0
        for (i in low..high) {
            // Check if the number is odd
            if (i % 2 != 0) {
                count++
            }
        }
        return count
    }
}
