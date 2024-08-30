package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/valid-palindrome
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            while (left < right && !s[left].isLetterOrDigit())
                left++
            while (left < right && !s[right].isLetterOrDigit())
                right--

            if (s[left].lowercaseChar() != s[right].lowercaseChar())
                return false

            left++
            right--
        }
        return true
    }
}
