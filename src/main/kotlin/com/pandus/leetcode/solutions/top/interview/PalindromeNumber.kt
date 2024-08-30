package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/palindrome-number
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        return "$x".reversed() == x.toString()
    }
}
