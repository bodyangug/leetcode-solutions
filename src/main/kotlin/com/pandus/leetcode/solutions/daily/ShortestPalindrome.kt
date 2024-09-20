package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/shortest-palindrome
class ShortestPalindrome {
    fun shortestPalindrome(s: String): String {
        val length = s.length
        val reversedString = s.reversed()

        // Iterate through the string to find the longest palindromic prefix
        for (i in 0 until length) {
            if (s.substring(0, length - i) == reversedString.substring(i)) {
                return reversedString.substring(0, i) + s
            }
        }
        return ""
    }
}
