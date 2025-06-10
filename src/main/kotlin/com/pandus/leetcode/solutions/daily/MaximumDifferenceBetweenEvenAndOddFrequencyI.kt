package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i
class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    fun maxDifference(s: String): Int {
        val freq = mutableMapOf<Char, Int>()
        for (ch in s) {
            freq[ch] = freq.getOrDefault(ch, 0) + 1
        }

        var maxOdd = 1
        var minEven = s.length

        for (count in freq.values) {
            if (count % 2 == 1) {
                maxOdd = maxOf(maxOdd, count)
            } else {
                minEven = minOf(minEven, count)
            }
        }

        return maxOdd - minEven
    }
}
