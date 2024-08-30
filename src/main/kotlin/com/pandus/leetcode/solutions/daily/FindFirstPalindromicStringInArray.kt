package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-first-palindromic-string-in-the-array
class FindFirstPalindromicStringInArray {
    fun firstPalindrome(words: Array<String>): String {
        return words.runCatching { return this.first { it.reversed() == it } }.getOrDefault("")
    }
}
