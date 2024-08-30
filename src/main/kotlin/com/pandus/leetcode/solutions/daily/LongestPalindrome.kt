package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-palindrome
class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        var oddFreqCharsCount = 0
        val frequencyMap: MutableMap<Char, Int> = HashMap()

        for (c in s.toCharArray()) {
            frequencyMap[c] = frequencyMap.getOrDefault(c, 0) + 1

            if ((frequencyMap[c]!! % 2) == 1) {
                oddFreqCharsCount++
            } else {
                oddFreqCharsCount--
            }
        }
        return if (oddFreqCharsCount > 0) {
            s.length - oddFreqCharsCount + 1
        } else {
            s.length
        }
    }
}
