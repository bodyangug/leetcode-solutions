package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-balloons
class MaximumNumberOfBalloons {
    fun maxNumberOfBalloons(text: String): Int {
        val balloonCount = mutableMapOf<Char, Int>()
        for (char in text) {
            if (char in "balloon") {
                balloonCount[char] = balloonCount.getOrDefault(char, 0) + 1
            }
        }
        val bCount = balloonCount.getOrDefault('b', 0)
        val aCount = balloonCount.getOrDefault('a', 0)
        val lCount = balloonCount.getOrDefault('l', 0) / 2
        val oCount = balloonCount.getOrDefault('o', 0) / 2
        val nCount = balloonCount.getOrDefault('n', 0)
        return minOf(bCount, aCount, lCount, oCount, nCount)
    }
}
